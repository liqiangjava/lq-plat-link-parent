package com.lq.plat.link.system;

import com.lq.plat.link.BaseModel;
import io.swagger.annotations.ApiModelProperty;

public class HotWordPara extends BaseModel {
    //名称
    @ApiModelProperty(value = "名称")
    private String name;
    //描述
    @ApiModelProperty(value = "描述")
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
