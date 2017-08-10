package com.lq.plat.link.service;

import com.lq.plat.link.knowledage.CurrentUserKnowledgeQuestionDto;
import com.lq.plat.link.knowledage.KnowledgeQuestionUpdatePara;
import com.lq.plat.link.knowledge.KnowledgeQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/7
 */
public interface KnowledgeQuestionService {

    public String save(KnowledgeQuestion knowledgeQuestion);

    public List<KnowledgeQuestion> findAll();

    public Page<KnowledgeQuestion> queryKnowledgeQuestion(KnowledgeQuestion knowledgeQuestion, Pageable pageable);

    public Page<CurrentUserKnowledgeQuestionDto> queryCurrentUserKnowledgeQuestion(String title,Long userId, Pageable pageable);

    public String update(KnowledgeQuestionUpdatePara knowledgeQuestionUpdatePara);
}
