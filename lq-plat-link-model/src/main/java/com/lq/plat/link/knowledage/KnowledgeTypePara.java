package com.lq.plat.link.knowledage;

import com.lq.plat.link.BaseModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
public class KnowledgeTypePara extends BaseModel {

    //名称
    @ApiModelProperty(value = "知识分类名称")
    private String name;
    //描述
    @ApiModelProperty(value = "知识分类描述")
    private String description;

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
}
