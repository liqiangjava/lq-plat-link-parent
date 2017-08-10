package com.lq.plat.link.knowledge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KnowledgeTypeDetail extends BaseEntity {

    //ID
    @Id
    private Long id;
    //名称
    private String name;
    //描述
    @Column(length = 500)
    private String description;


    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "knowledge_type_id",referencedColumnName = "id")
    @JsonIgnore
    private KnowledgeType knowledgeType;

    public KnowledgeTypeDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public KnowledgeType getKnowledgeType() {
        return knowledgeType;
    }

    public void setKnowledgeType(KnowledgeType knowledgeType) {
        this.knowledgeType = knowledgeType;
    }
}
