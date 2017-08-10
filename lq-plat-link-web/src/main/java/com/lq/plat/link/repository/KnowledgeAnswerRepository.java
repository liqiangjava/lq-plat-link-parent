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
     * select questionUser.username as payerUsername, -- 付款者名称
     * question.price as payerPrice, -- 付款者金额
     * question.title as payerQuestionTitle, -- 付款者问题标题
     * payerAccount.name as payerAccountName, -- 付款者账户信息
     * payerOrder.id as payerOrderId, -- 付款者订单ID
     * answerUser.username as payeeUsername, -- 收款者用户名
     * answerUser.portrait as payeePortrait, -- 收款者头像
     * answerUser.mobile as payeeMobile, -- 收款者手机号
     * answerUser.email as payeeEmail,-- 收款者邮箱号
     * payeeia.name as payeeAccountName, -- 收款者账户名称
     * payeeia.receivables_qrcode as payeeReceivablesQrcode  -- 收款者二维码
     * from knowledge_question question
     * left join knowledge_answer answer
     * on question.id = answer.knowledge_question_id
     * left join info_user questionUser
     * on  question.create_user = questionUser.id
     * left join info_account payerAccount
     * on questionUser.create_user = payerAccount.info_user_id
     * left join info_order payerOrder
     * on payerOrder.payer_user_id = questionUser.id
     * left join info_user answerUser
     * on answer.create_user = answerUser.id
     * left join info_account payeeia
     * on answerUser.id = payeeia.info_user_id
     * where answer.best_answers = true -- 最佳回答者
     * and payeeia.status = 0    -- 收款者账户可用
     * and question.status = 2   -- 问题已解决
     * order by answer.modify_time desc
     */
    @Query(value = "select questionUser.username as payerUsername, question.price as payerPrice,  question.title as payerQuestionTitle,  payerAccount.name as payerAccountName,  payerOrder.id as payerOrderId,  answerUser.username as payeeUsername, answerUser.portrait as payeePortrait,  answerUser.mobile as payeeMobile,  answerUser.email as payeeEmail, payeeia.name as payeeAccountName,  payeeia.receivables_qrcode as payeeReceivablesQrcode   from knowledge_question question left join knowledge_answer answer  on question.id = answer.knowledge_question_id left join info_user questionUser on  question.create_user = questionUser.id left join info_account payerAccount on questionUser.create_user = payerAccount.info_user_id left join info_order payerOrder on payerOrder.payer_user_id = questionUser.id left join info_user answerUser on answer.create_user = answerUser.id  left join info_account payeeia on answerUser.id = payeeia.info_user_id where answer.best_answers = true  and payeeia.status = 0  and question.status = 2 order by answer.modify_time desc  \n-- #pageable\n ",
            countQuery = "select count(questionUser.username) from knowledge_question question left join knowledge_answer answer  on question.id = answer.knowledge_question_id left join info_user questionUser on  question.create_user = questionUser.id left join info_account payerAccount on questionUser.create_user = payerAccount.info_user_id left join info_order payerOrder on payerOrder.payer_user_id = questionUser.id left join info_user answerUser on answer.create_user = answerUser.id  left join info_account payeeia on answerUser.id = payeeia.info_user_id where answer.best_answers = true  and payeeia.status = 0  and question.status = 2 order by answer.modify_time desc"
            , nativeQuery = true)
    public Page<BestResponderDto> findBestResponder(Pageable pageable);
}
