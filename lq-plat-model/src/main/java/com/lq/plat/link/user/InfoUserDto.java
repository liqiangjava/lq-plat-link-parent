package com.lq.plat.link.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户返回数据
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/4
 */
public class InfoUserDto {

    @ApiModelProperty(value = "ID")
    private Long id;

    //手机号
    @ApiModelProperty(value = "手机号")
    private String mobile;

    //邮箱
    @ApiModelProperty(value = "邮箱")
    private String email;

    //登录类型
    @ApiModelProperty(value = "登录类型")
    private Integer loginModel;

    //用户名
    @ApiModelProperty(value = "用户名")
    private String username;

    //描述
    @ApiModelProperty(value = "描述")
    private String description;

    //性别
    @ApiModelProperty(value = "性别")
    private String sex;

    //头像
    @ApiModelProperty(value = "头像")
    private String portrait;

    //职位
    @ApiModelProperty(value = "职位")
    private String position;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(Integer loginModel) {
        this.loginModel = loginModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
