package com.lq.plat.link.repository;

import com.lq.plat.link.knowledge.KnowledgeQuestionCollect;
import com.lq.plat.link.support.PlatFormRepository;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/7
 */
public interface QuestionCollectRepository extends PlatFormRepository<KnowledgeQuestionCollect> {

    public KnowledgeQuestionCollect findByCreateUserAndQuestionId(Long userId,Long questionId);
}
