package com.lq.plat.link.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/28
 */
public class PlatFormInfoUserPara {

    @ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "用户密码不能为空")
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
