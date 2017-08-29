package com.lq.plat.link.system;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * 系统通知模板
 * @author 李强
 * @versin 1.0.0
 * @date 2017/8/16
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SysNotifyTemplate extends BaseEntity{

    //ID
    @Id
    private Long id;

    //业务事件
    private String event;

    //操作类型
    private String status;

    //通过类型
    private String notifyType;

    //内容
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
