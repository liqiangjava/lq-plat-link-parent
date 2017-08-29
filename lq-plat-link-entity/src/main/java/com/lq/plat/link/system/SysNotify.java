package com.lq.plat.link.system;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * 系统通知
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/16
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SysNotify extends BaseEntity {

    //ID
    @Id
    private Long id;

    //发送者
    private String sender;

    //接收者
    private String receiver;

    //类型:1.系统通过 2...
    private Integer type;

    //是否已读(false 未读，true 已读)
    private boolean readFlag = false;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isReadFlag() {
        return readFlag;
    }

    public void setReadFlag(boolean readFlag) {
        this.readFlag = readFlag;
    }
}
