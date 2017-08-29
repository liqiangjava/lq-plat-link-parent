package com.lq.plat.link.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.BaseEntity;
import com.lq.plat.link.user.InfoUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 账户实体类
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoAccount extends BaseEntity {

    //ID
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "info_user_id",referencedColumnName = "id")
    @JsonIgnore
    private InfoUser infoUser;

    //账户状态 0 可用 1 注销
    private Integer status = 0;

    //账户余额
    private BigDecimal balance ;

    //账户类型 0 支付宝 1 微信
    private Integer type;

    //账户名称（方便查找对应账户信息）
    private String name;

    //收款二维码
    private String receivablesQrcode;

    public InfoAccount() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReceivablesQrcode() {
        return receivablesQrcode;
    }

    public void setReceivablesQrcode(String receivablesQrcode) {
        this.receivablesQrcode = receivablesQrcode;
    }

}
