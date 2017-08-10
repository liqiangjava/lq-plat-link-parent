package com.lq.plat.link.repository;

import com.lq.plat.link.knowledage.BestResponderDto;
import com.lq.plat.link.knowledge.KnowledgeAnswer;
import com.lq.plat.link.support.PlatFormRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public interface KnowledgeAnswerRepository extends PlatFormRepository<KnowledgeAnswer> {

    @Query(value="select  count(ka.create_user) as count ,iu.mobile as mobile ,iu.email as email,iu.login_model as loginModel,iu.username as username,iu.description as description,iu.sex as sex,iu.portrait as portrait,iu.position as position from knowledge_answer ka inner join info_user iu on ka.create_user = iu.id where date_format(ka.create_date,'%Y-%m') = date_format(now(),'%Y-%m') group by ka.create_user order by count desc limit ?1",nativeQuery=true)
    public List findMonthBestResponder(Integer size);

    public KnowledgeAnswer findByIdAndCreateUser(Long id, Long createUser);

    @Query(value = "select ka.* from knowledge_answer ka where ka.knowledge_question_id = ?1 and ka.create_user = ?2",nativeQuery=true)
    public KnowledgeAnswer findKnowledgeAnserByQuestionIdAndCreateUser(Long questionId, Long createUser);

    @Query("")
    Page<BestResponderDto> findBestResponder(Pageable pageable);
}
