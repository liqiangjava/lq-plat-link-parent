package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledage.BestResponderDto;
import com.lq.plat.link.knowledage.KnowledgeAnswerPara;
import com.lq.plat.link.knowledage.MonthBestResponderDto;
import com.lq.plat.link.knowledge.KnowledgeAnswer;
import com.lq.plat.link.knowledge.KnowledgeQuestion;
import com.lq.plat.link.repository.KnowledgeAnswerDao;
import com.lq.plat.link.repository.KnowledgeAnswerRepository;
import com.lq.plat.link.repository.KnowledgeQuestionRepository;
import com.lq.plat.link.service.KnowledgeAnswerService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.WebUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
@Service
public class KnowledgeAnswerServiceImpl implements KnowledgeAnswerService {

    @Autowired
    private KnowledgeAnswerRepository knowledgeAnswerRepository;

    @Autowired
    private KnowledgeQuestionRepository knowledgeQuestionRepository;

    @Autowired
    private KnowledgeAnswerDao knowledgeAnswerDao;

    @Override
    public String save(KnowledgeAnswerPara knowledgeAnswerPara, Long id) {
        try {

            KnowledgeQuestion knowledgeQuestion = knowledgeQuestionRepository.findOne(id);
            if (knowledgeQuestion == null) {
                return ConstantParaUtil.KNOWLEDGE_QUESTION_NO_EXISTS;
            }
            if (knowledgeQuestion.getKnowledgeAnswers().size() > 0) {
                return ConstantParaUtil.KNOWLEDGE_QUESTION_REPEAT_ANSWER;
            }
            KnowledgeAnswer knowledgeAnswer = DTOUtils.map(knowledgeAnswerPara, KnowledgeAnswer.class);
            knowledgeAnswer.setKnowledgeQuestion(knowledgeQuestion);
            knowledgeAnswer.setId(WebUtils.getIdWorker().nextId());
            knowledgeAnswerRepository.save(knowledgeAnswer);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }

    @Override
    public List<MonthBestResponderDto> monthBestResponder(Integer size) {
        List<MonthBestResponderDto> monthBestResponderDtos = knowledgeAnswerDao.monthBestResponder(size);
        return monthBestResponderDtos;
    }

    @Override
    public String update(KnowledgeAnswerPara knowledgeAnswerPara) {
        Long userId = UserSecurityUtils.getInfoUserId();
        KnowledgeAnswer knowledgeAnswer = knowledgeAnswerRepository.findByIdAndCreateUser(knowledgeAnswerPara.getId(), userId);
        if (knowledgeAnswer == null) {
            return ConstantParaUtil.KNOWLEDGE_QUESTION_NO_EXISTS;
        }
        try {
            knowledgeAnswerRepository.save(DTOUtils.map(knowledgeAnswerPara, KnowledgeAnswer.class));
            return ConstantParaUtil.SUCCESS_UPDATE_CH;
        } catch (Exception e) {
            return ConstantParaUtil.FALSE_UPDATE_CH;
        }

    }

    @Transactional
    @Override
    public String updateKnowledgeQuestionsBestAnswers(Long answerId, Long questionId) {
        try {
            KnowledgeAnswer knowledgeAnswer = knowledgeAnswerRepository.findKnowledgeAnserByQuestionIdAndCreateUser(questionId, answerId);
            if (knowledgeAnswer == null) {
                return ConstantParaUtil.NOT_SET_ANSWER_BY_QUESTION_CREATEUSER;
            }
            knowledgeAnswer.setBestAnswers(true);//最佳回答者
            knowledgeAnswerRepository.save(knowledgeAnswer);
            KnowledgeQuestion knowledgeQuestion = knowledgeQuestionRepository.findOne(questionId);
            if (knowledgeQuestion == null) {
                return ConstantParaUtil.KNOWLEDGE_QUESTION_NO_EXISTS;
            }
            knowledgeQuestion.setStatus(2);//已解决
            knowledgeQuestionRepository.save(knowledgeQuestion);

            return ConstantParaUtil.SUCCESS_UPDATE_CH;
        } catch (Exception e) {
            return ConstantParaUtil.FALSE_UPDATE_CH;
        }
    }

    @Override
    public Page<BestResponderDto> findBestAnswer(Pageable pageable) {
        Page<BestResponderDto> pageData = knowledgeAnswerRepository.findBestResponder(pageable);
        return pageData;
    }

}
