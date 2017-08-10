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

    @Query(value = "select  count(ka.create_user) as count ,iu.mobile as mobile ,iu.email as email,iu.login_model as loginModel,iu.username as username,iu.description as description,iu.sex as sex,iu.portrait as portrait,iu.position as position from knowledge_answer ka inner join info_user iu on ka.create_user = iu.id where date_format(ka.create_date,'%Y-%m') = date_format(now(),'%Y-%m') group by ka.create_user order by count desc limit ?1", nativeQuery = true)
    public List findMonthBestResponder(Integer size);

    public KnowledgeAnswer findByIdAndCreateUser(Long id, Long createUser);

    @Query(value = "select ka.* from knowledge_answer ka where ka.knowledge_question_id = ?1 and ka.create_user = ?2", nativeQuery = true)
    public KnowledgeAnswer findKnowledgeAnserByQuestionIdAndCreateUser(Long questionId, Long createUser);

    /**
     * select kqiu.username as payerUsername, -- 付款者名称
     * kq.price as payerPrice, -- 付款者金额
     * kq.title as payerQuestionTitle, -- 付款者问题标题
     * payeria.name as payerAccountName, -- 付款者账户信息
     * kaiu.username as payeeUsername, -- 收款者用户名
     * kaiu.portrait as payeePortrait, -- 收款者头像
     * kaiu.mobile as payeeMobile, -- 收款者手机号
     * kaiu.email as payeeEmail,-- 收款者邮箱号
     * payeeia.name as payeeAccountName, -- 收款者账户名称
     * payeeia.receivables_qrcode as payeeReceivablesQrcode  -- 收款者二维码
     * from knowledge_question kq
     * left join knowledge_answer ka
     * on kq.id = ka.knowledge_question_id
     * left join info_user kqiu
     * on  kq.create_user = kqiu.id
     * left join info_account payeria
     * on kqiu.create_user = payeria.info_user_id
     * left join info_user kaiu
     * on ka.create_user = kaiu.id
     * left join info_account payeeia
     * on kaiu.id = payeeia.info_user_id
     * where ka.best_answers = true -- 最佳回答者
     * and payeeia.status = 0    -- 收款者账户可用
     * and kq.status = 2   -- 问题已解决
     * order by ka.modify_time desc
     */
    @Query("select kqiu.username as payerUsername,kq.price as payerPrice,kq.title as payerQuestionTitle,payeria.name as payerAccountName, kaiu.username as payeeUsername, kaiu.portrait as payeePortrait,kaiu.mobile as payeeMobile,kaiu.email as payeeEmail,payeeia.name as payeeAccountName,payeeia.receivables_qrcode as payeeReceivablesQrcode from knowledge_question kq left join knowledge_answer ka on kq.id = ka.knowledge_question_id left join info_user kqiu on  kq.create_user = kqiu.id left join info_account payeria on kqiu.create_user = payeria.info_user_id left join info_user kaiu on ka.create_user = kaiu.id left join info_account payeeia on kaiu.id = payeeia.info_user_id where ka.best_answers = true and payeeia.status = 0 and kq.status = 2 order by ka.modify_time desc")
    Page<BestResponderDto> findBestResponder(Pageable pageable);
}
