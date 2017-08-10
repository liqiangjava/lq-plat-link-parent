package com.lq.plat.link.knowledge;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 问题实体类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KnowledgeQuestion extends BaseEntity {

    //ID
    @Id
    private Long id;
    //问题标题
    @Column(length = 500)
    private String title;
    //问题描述
    @Column(columnDefinition = "TEXT")
    private String description;
    //知识类型
    private String typeNames;
    //等待时间 20分钟,无就是普通问题
    private Integer waitingTime;
    //超时重复提交 0不重复 1重复
    private Integer timeOutSubmit;
    //价格
    @Column(name = "price", nullable = true)
    private BigDecimal price;
    //问题状态:0.待发布 1.已发布  2.已解决
    private Integer status = 0;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "knowledgeQuestion")
    private List<KnowledgeAnswer> knowledgeAnswers;


    public KnowledgeQuestion() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<KnowledgeAnswer> getKnowledgeAnswers() {
        return knowledgeAnswers;
    }

    public void setKnowledgeAnswers(List<KnowledgeAnswer> knowledgeAnswers) {
        this.knowledgeAnswers = knowledgeAnswers;
    }

    public Integer getTimeOutSubmit() {
        return timeOutSubmit;
    }

    public void setTimeOutSubmit(Integer timeOutSubmit) {
        this.timeOutSubmit = timeOutSubmit;
    }
}
