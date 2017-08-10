package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/9
 */
public class KnowledgeQuestionUpdatePara {

    //ID
    @ApiModelProperty(value = "ID")
    @NotNull(message = "ID不能为空")
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
    //问题状态:0.待发布 1.已发布  2.已解决
    @ApiModelProperty(value = "问题状态:0.待发布 1.已发布  2.已解决")
    private Integer status = 0;

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
}
