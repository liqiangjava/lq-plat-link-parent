package com.lq.plat.link.knowledage;

import com.lq.plat.link.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 问题实体类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
public class KnowledgeQuestionPara extends BaseModel{

    //问题标题
    @ApiModelProperty(value = "问题标题")
    @NotNull(message = "问题标题不能为空")
    private String title;
    //问题描述
    @ApiModelProperty(value = "问题描述")
    @NotNull(message = "问题描述不能为空")
    private String description;
    //知识类型
    @ApiModelProperty(value = "知识类型:如JAVA,PHP,C#")
    @NotNull(message = "知识类型不能为空")
    private String typeNames;
    //等待时间
    @ApiModelProperty(value = "等待时间")
    @NotNull(message = "等待时间不能为空")
    private Integer waitingTime;
    //价格
    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "是否超时重复提交 0不重复 1重复")
    @NotNull(message = "是否超时重复提交为空")
    private Integer timeOutSubmit;


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

    public Integer getTimeOutSubmit() {
        return timeOutSubmit;
    }

    public void setTimeOutSubmit(Integer timeOutSubmit) {
        this.timeOutSubmit = timeOutSubmit;
    }
}
