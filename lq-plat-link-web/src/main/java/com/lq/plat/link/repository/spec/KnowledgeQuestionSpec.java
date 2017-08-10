package com.lq.plat.link.repository.spec;

import com.lq.plat.link.knowledge.KnowledgeQuestion;
import com.lq.plat.link.repository.spec.support.PlatformSimpleSpecification;
import com.lq.plat.link.repository.spec.support.QueryWraper;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/9
 */
public class KnowledgeQuestionSpec extends PlatformSimpleSpecification<KnowledgeQuestion, KnowledgeQuestion> {


    public KnowledgeQuestionSpec(KnowledgeQuestion condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<KnowledgeQuestion> queryWraper) {

        addLikeCondition(queryWraper, "title");
        addEqualsCondition(queryWraper,"createUser");



    }



}
