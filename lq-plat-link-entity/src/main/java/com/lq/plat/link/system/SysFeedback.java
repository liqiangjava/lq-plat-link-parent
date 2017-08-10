package com.lq.plat.link.system;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 反馈我们
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/4
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SysFeedback extends BaseEntity {

    @Id
    private Long id;
    //名称
    private String name;
    //联系方式
    private String contactInfo;
    //内容
    @Column(columnDefinition = "TEXT")
    private String content;


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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
