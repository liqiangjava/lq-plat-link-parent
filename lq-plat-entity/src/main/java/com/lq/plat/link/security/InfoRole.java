package com.lq.plat.link.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * 角色
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/30
 */
@Entity
public class InfoRole {

    @Id
    @GeneratedValue
    private Long id;

    //名称
    private String name;

    //描述
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "infoRole")
    @JsonIgnore
    private List<InfoUserRole> infoUserRoles;

    public InfoRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<InfoUserRole> getInfoUserRoles() {
        return infoUserRoles;
    }

    public void setInfoUserRoles(List<InfoUserRole> infoUserRoles) {
        this.infoUserRoles = infoUserRoles;
    }
}
