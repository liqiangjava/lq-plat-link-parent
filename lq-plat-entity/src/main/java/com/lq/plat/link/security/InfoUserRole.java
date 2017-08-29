package com.lq.plat.link.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.user.InfoUser;

import javax.persistence.*;

/**
 * 用户与角色关系表
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/30
 */
@Entity
public class InfoUserRole {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "info_user_id",referencedColumnName = "id")
    @JsonIgnore
    private InfoUser infoUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_role_id",referencedColumnName = "id")
    @JsonIgnore
    private InfoRole infoRole;

    public InfoUserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InfoUser getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    public InfoRole getInfoRole() {
        return infoRole;
    }

    public void setInfoRole(InfoRole infoRole) {
        this.infoRole = infoRole;
    }
}
