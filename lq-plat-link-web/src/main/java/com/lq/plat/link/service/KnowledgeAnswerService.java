package com.lq.plat.link.service;

import com.lq.plat.link.knowledage.BestResponderDto;
import com.lq.plat.link.knowledage.KnowledgeAnswerPara;
import com.lq.plat.link.knowledage.MonthBestResponderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public interface KnowledgeAnswerService {

    public String save(KnowledgeAnswerPara knowledgeAnswer,Long id);

    public List<MonthBestResponderDto> monthBestResponder(Integer size);

    public String update(KnowledgeAnswerPara knowledgeAnswerPara);

    public String updateKnowledgeQuestionsBestAnswers(Long answerId, Long questionId);

    public Page<BestResponderDto> findBestAnswer(Pageable pageable);
}
