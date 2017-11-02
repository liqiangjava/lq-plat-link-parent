package com.lq.plat.link.service.impl;

import com.alibaba.fastjson.JSON;
import com.lq.plat.link.aspect.ServiceLog;
import com.lq.plat.link.aspect.ServiceLogAspect;
import com.lq.plat.link.aspect.ServiceSysNotify;
import com.lq.plat.link.common.Constant;
import com.lq.plat.link.knowledage.CurrentUserKnowledgeQuestionDto;
import com.lq.plat.link.knowledage.KnowledgeQuestionUpdatePara;
import com.lq.plat.link.knowledage.OrderStatusEnum;
import com.lq.plat.link.knowledge.KnowledgeQuestion;
import com.lq.plat.link.knowledge.KnowledgeQuestionCollect;
import com.lq.plat.link.order.InfoOrder;
import com.lq.plat.link.repository.InfoOrderRepository;
import com.lq.plat.link.repository.KnowledgeQuestionRepository;
import com.lq.plat.link.repository.QuestionCollectRepository;
import com.lq.plat.link.repository.spec.KnowledgeQuestionSpec;
import com.lq.plat.link.service.KnowledgeQuestionService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.WebUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/7
 */
@Service
@Transactional
public class KnowledgeQuestionServiceImpl implements KnowledgeQuestionService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogAspect.class);


    @Autowired
    private KnowledgeQuestionRepository knowledgeQuestionRepository;

    @Autowired
    private QuestionCollectRepository questionCollectRepository;

    @Autowired
    private InfoOrderRepository infoOrderRepository;

    @Override
    @ServiceSysNotify(event = "abcd",status = "efhj")
    public String save(KnowledgeQuestion knowledgeQuestion) {
        try {
            knowledgeQuestion.setId( WebUtils.getIdWorker().nextId());
            KnowledgeQuestion newKnowledgeQuestion = knowledgeQuestionRepository.save(knowledgeQuestion);
            //因为提交的问题,默认价格是最少2元,所以可以直接生成订单
            InfoOrder infoOrder = new InfoOrder();
            infoOrder.setId(WebUtils.getIdWorker().nextId());
            infoOrder.setPayerUserId(UserSecurityUtils.getInfoUserId());
            infoOrder.setCapitalPayAmount(knowledgeQuestion.getPrice());
            infoOrder.setStatus(OrderStatusEnum.ORDER_NONEPROCESS.getValue());
            infoOrderRepository.save(infoOrder);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }

    @Override
    public List<KnowledgeQuestion> findAll() {
        return knowledgeQuestionRepository.findAll();
    }

    @Override
    @ServiceLog
    public Page<KnowledgeQuestion> queryKnowledgeQuestion(KnowledgeQuestion knowledgeQuestion, Pageable pageable) {

        Page<KnowledgeQuestion> pageData = knowledgeQuestionRepository.findAll(new KnowledgeQuestionSpec(knowledgeQuestion), pageable);
        LOGGER.info(JSON.toJSONString(pageData.getContent()));
        return pageData;
    }


    @Override
    public Page<CurrentUserKnowledgeQuestionDto> queryCurrentUserKnowledgeQuestion(String title,Long userId, Pageable pageable) {
        Page<KnowledgeQuestion> knowledgeQuestionPage = null;
        if(StringUtils.isNotBlank(title)){
            knowledgeQuestionPage = knowledgeQuestionRepository.findCurrentUserKnowledgeQuestionByTitleAndCreateUser(title,userId,pageable);
        }else{
            knowledgeQuestionPage = knowledgeQuestionRepository.findCurrentUserKnowledgeQuestionByCreateUser(userId, pageable);
        }
        List<KnowledgeQuestion> knowledgeQuestions = knowledgeQuestionPage.getContent();
        List<CurrentUserKnowledgeQuestionDto> currentUserKnowledgeQuestionDtos = DTOUtils.map(knowledgeQuestions,CurrentUserKnowledgeQuestionDto.class);
        for (CurrentUserKnowledgeQuestionDto currentUserKnowledgeQuestionDto:currentUserKnowledgeQuestionDtos) {
            if(StringUtils.equals(currentUserKnowledgeQuestionDto.getCreateUser().toString(),userId.toString())){
                //判断当前用户是否收藏
                KnowledgeQuestionCollect questionCollect= questionCollectRepository.findByCreateUserAndQuestionId(userId,currentUserKnowledgeQuestionDto.getId());
                if(questionCollect != null){
                    currentUserKnowledgeQuestionDto.setFavorite(questionCollect.getFavorite());
                }
                currentUserKnowledgeQuestionDto.setQuestionOrAnswer(Constant.QUESTION_ANSWER_TYPE.QUESTION.name());
            }else{
                currentUserKnowledgeQuestionDto.setQuestionOrAnswer(Constant.QUESTION_ANSWER_TYPE.ANSWER.name());
            }
        }

        Page<CurrentUserKnowledgeQuestionDto> currentUserKnowledgeQuestionDtoPage = new PageImpl<CurrentUserKnowledgeQuestionDto>(currentUserKnowledgeQuestionDtos, pageable, knowledgeQuestionPage.getTotalElements());
        return currentUserKnowledgeQuestionDtoPage;
    }

    @Override
    public String update(KnowledgeQuestionUpdatePara knowledgeQuestionUpdatePara) {

        try {
            knowledgeQuestionRepository.save(DTOUtils.map(knowledgeQuestionUpdatePara,KnowledgeQuestion.class));
            return ConstantParaUtil.SUCCESS_UPDATE_CH;
        } catch (Exception e) {
            return ConstantParaUtil.FALSE_UPDATE_CH;
        }
    }

    @Override
    public Page<KnowledgeQuestion> getTBAKnowledgeQuestions(Pageable pageable) {
        return knowledgeQuestionRepository.findByStatus(0,pageable);
    }
}
