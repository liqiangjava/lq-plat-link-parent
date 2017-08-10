package com.lq.plat.link.knowledage;

import com.lq.plat.link.PlatformModel;
import com.lq.plat.link.knowledge.KnowledgeAnswer;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * 当前用名知识答案
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/12
 */
public class CurrentUserKnowledgeQuestionDto extends PlatformModel{

    @ApiModelProperty(value = "ID")
    private Long id;
    //问题标题
    @ApiModelProperty(value = "问题标题")
    private String title;
    //问题描述
    @ApiModelProperty(value = "问题描述")
    private String description;
    //知识类型
    @ApiModelProperty(value = "知识类型")
    private String typeNames;
    //等待时间 20分钟,无就是普通问题
    @ApiModelProperty(value = "等待时间 20分钟,无就是普通问题")
    private Integer waitingTime;
    //超时重复提交 0不重复 1重复
    @ApiModelProperty(value = "超时重复提交 0不重复 1重复")
    private Integer timeOutSubmit;
    //价格
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    //问题状态:0.未解决  1.已解决
    @ApiModelProperty(value = "0.未解决  1.已解决")
    private Integer status = 0;

    @ApiModelProperty(value = "问题回答")
    private List<KnowledgeAnswer> knowledgeAnswers;

    //问题或答案
    @ApiModelProperty(value = "QUESTION问题,ANSWER回答")
    private String questionOrAnswer;

    @ApiModelProperty(value = "是否收藏")
    private Boolean favorite = false;


    public CurrentUserKnowledgeQuestionDto() {
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

    public Integer getTimeOutSubmit() {
        return timeOutSubmit;
    }

    public void setTimeOutSubmit(Integer timeOutSubmit) {
        this.timeOutSubmit = timeOutSubmit;
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

    public String getQuestionOrAnswer() {
        return questionOrAnswer;
    }

    public void setQuestionOrAnswer(String questionOrAnswer) {
        this.questionOrAnswer = questionOrAnswer;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
