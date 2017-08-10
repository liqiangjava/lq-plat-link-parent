package com.lq.plat.link.knowledage;

import com.lq.plat.link.BaseModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 知识点答案请求类
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public class KnowledgeAnswerPara extends BaseModel{

    @ApiModelProperty(value = "答案ID：新增时不用传，更新时传ID值")
    private Long id;

    //描述
    @ApiModelProperty(value = "描述")
    private String description;
    //知识类型
    @ApiModelProperty(value = "知识类型,如:JAVA,C#")
    private String typeNames;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
