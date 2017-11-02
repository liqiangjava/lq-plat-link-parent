package com.lq.plat.link.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.BaseEntity;
import com.lq.plat.link.account.InfoAccount;
import com.lq.plat.link.security.InfoUserRole;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 用户成员表实体类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoUser extends BaseEntity {

    //ID
    @Id
    private Long id;

    //手机号
    @Column(unique = true)
    private String mobile;

    //邮箱
    @Column(unique = true)
    private String email;

    //登录类型(手机方式:1手机:2邮箱,其它:3)
    private Integer loginModel;

    //用户名
    @Column(unique = true)
    private String username;

    //密码
    @Column(nullable = false)
    private String password;

    //描述
    private String description;

    //性别
    private String sex;

    //头像
    private String portrait;

    //职位
    private String position;

    //用户状态:0:使用 1:删除  -- 2.实名审核通过 3.实名未审核通过
    private Integer status= 0;

    //角色
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "infoUser")
    @JsonIgnore
    private List<InfoUserRole> infoUserRoles;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy = "infoUser")
    private InfoAccount infoAccount;

    public InfoUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<InfoUserRole> getInfoUserRoles() {
        return infoUserRoles;
    }

    public void setInfoUserRoles(List<InfoUserRole> infoUserRoles) {
        this.infoUserRoles = infoUserRoles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public InfoAccount getInfoAccount() {
        return infoAccount;
    }

    public void setInfoAccount(InfoAccount infoAccount) {
        this.infoAccount = infoAccount;
    }
}
