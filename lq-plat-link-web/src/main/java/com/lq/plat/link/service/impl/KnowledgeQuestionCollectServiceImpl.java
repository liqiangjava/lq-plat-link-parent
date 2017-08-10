package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledge.KnowledgeQuestionCollect;
import com.lq.plat.link.repository.QuestionCollectRepository;
import com.lq.plat.link.service.KnowledgeQuestionCollectService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/3
 */
@Service
public class KnowledgeQuestionCollectServiceImpl implements KnowledgeQuestionCollectService {

    @Autowired
    private QuestionCollectRepository questionCollectRepository;

    @Override
    public String save(KnowledgeQuestionCollect questionCollect) {
        try {
            questionCollect.setId( WebUtils.getIdWorker().nextId());
            questionCollectRepository.save(questionCollect);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }
}
