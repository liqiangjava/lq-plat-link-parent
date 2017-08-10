package com.lq.plat.link.knowledge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 答案实体类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KnowledgeAnswer extends BaseEntity {

    //ID
    @Id
    private Long id;

    //描述
    @Column(columnDefinition = "TEXT")
    private String description;

    //知识类型
    private String typeNames;

    //是否最佳回答者
    private boolean bestAnswers = false;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "knowledge_question_id",referencedColumnName = "id")
    @JsonIgnore
    private KnowledgeQuestion knowledgeQuestion;

    public KnowledgeAnswer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(String typeNames) {
        this.typeNames = typeNames;
    }

    public KnowledgeQuestion getKnowledgeQuestion() {
        return knowledgeQuestion;
    }

    public void setKnowledgeQuestion(KnowledgeQuestion knowledgeQuestion) {
        this.knowledgeQuestion = knowledgeQuestion;
    }

    public boolean isBestAnswers() {
        return bestAnswers;
    }

    public void setBestAnswers(boolean bestAnswers) {
        this.bestAnswers = bestAnswers;
    }
}
