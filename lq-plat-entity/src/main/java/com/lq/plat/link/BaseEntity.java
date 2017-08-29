package com.lq.plat.link;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@MappedSuperclass
public class BaseEntity {


    //创建用户
    @CreatedBy
    private Long createUser;

    //更新用户
    @LastModifiedBy
    private Long updateUser;

    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    @CreatedDate
    private Date createDate;

    /**
     * 最后修改时间
     **/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    @LastModifiedDate
    private Date modifyTime;

    //数据标签 0 是测试,1是正式
    @Column
    private Integer dataSign = 1;


    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDataSign() {
        return dataSign;
    }

    public void setDataSign(Integer dataSign) {
        this.dataSign = dataSign;
    }

}
