package com.lq.plat.link.trade;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 付款订单
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PaymentOrder  extends BaseEntity {

    //ID
    @Id
    private Long id;


    /**
     * 问题订单号
     */
    private String questionOrderNo;

    /**
     * 问题名称
     */
    private String questionName;

    /**
     * 付款用户ID
     */
    private Long payerUserId;


    /**
     * 付款用户名称
     */
    private String payUserName;

    /**
     * 订单时间
     */
    private Date orderTime;

    /**
     * 订单IP
     */
    private String orderIp;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount  = BigDecimal.ZERO;

    /** 状态(参考枚举:OrderStatusEnum) **/
    private Integer status;

    /** 支付方式类型(参考枚举:TradePaymentTypeEnum) **/
    private Integer paymentType;



    public PaymentOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionOrderNo() {
        return questionOrderNo;
    }

    public void setQuestionOrderNo(String questionOrderNo) {
        this.questionOrderNo = questionOrderNo;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Long getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(Long payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getPayUserName() {
        return payUserName;
    }

    public void setPayUserName(String payUserName) {
        this.payUserName = payUserName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }



}
