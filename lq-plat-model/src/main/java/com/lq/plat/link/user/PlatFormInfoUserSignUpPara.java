package com.lq.plat.link.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/28
 */
public class PlatFormInfoUserSignUpPara {

    @ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "用户密码不能为空")
    private String password1;

    @ApiModelProperty(value = "确认密码")
    @NotNull(message = "用户确认密码不能为空")
    private String password2;

    @ApiModelProperty(value = "登录类型(1为手机方式,2为邮箱,3为其它)")
    private Integer model = 1;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
