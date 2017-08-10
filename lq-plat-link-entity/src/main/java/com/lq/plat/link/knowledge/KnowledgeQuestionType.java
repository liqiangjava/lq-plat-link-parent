package com.lq.plat.link.knowledge;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * 知识问题类型实体类
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
public class KnowledgeQuestionType {

    //ID
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "knowledge_question_id",referencedColumnName = "id")
    @JsonIgnore
    private KnowledgeQuestion knowledgeQuestion;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "knowledge_type_id",referencedColumnName = "id")
    @JsonIgnore
    private KnowledgeType knowledgeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KnowledgeQuestion getKnowledgeQuestion() {
        return knowledgeQuestion;
    }

    public void setKnowledgeQuestion(KnowledgeQuestion knowledgeQuestion) {
        this.knowledgeQuestion = knowledgeQuestion;
    }

    public KnowledgeType getKnowledgeType() {
        return knowledgeType;
    }

    public void setKnowledgeType(KnowledgeType knowledgeType) {
        this.knowledgeType = knowledgeType;
    }
}
