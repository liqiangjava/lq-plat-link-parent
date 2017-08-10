package com.lq.plat.link.repository;

import com.lq.plat.link.knowledge.KnowledgeQuestion;
import com.lq.plat.link.support.PlatFormRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/7
 */
public interface KnowledgeQuestionRepository extends PlatFormRepository<KnowledgeQuestion> {

    @Query("select kq from KnowledgeQuestion kq left join kq.knowledgeAnswers ka where kq.title like :title and  kq.createUser =:userId or ka.createUser =:userId")
    public Page<KnowledgeQuestion> findCurrentUserKnowledgeQuestionByTitleAndCreateUser(@Param("title") String title,@Param("userId") Long userId, Pageable pageable);


    @Query("select kq from KnowledgeQuestion kq left join kq.knowledgeAnswers ka  where   kq.createUser =:userId or ka.createUser =:userId")
    public Page<KnowledgeQuestion> findCurrentUserKnowledgeQuestionByCreateUser(@Param("userId") Long userId, Pageable pageable);

}
