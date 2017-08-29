package com.lq.plat.link.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/6
 */
public class InfoRolePara  {

    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称不能为空")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
