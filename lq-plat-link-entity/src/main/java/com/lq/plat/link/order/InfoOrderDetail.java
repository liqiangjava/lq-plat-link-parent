package com.lq.plat.link.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 订单明细
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/10
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoOrderDetail extends BaseEntity {

    //ID
    @Id
    private Long id;

    /**
     * 付款人ID
     */
    private Long payerUserId;

    /**
     * 收款人ID
     */
    private Long payeeUserId;

    /**
     * 付款人支付金额
     */
    private BigDecimal capitalPayAmount = BigDecimal.ZERO;

    /**
     * 订单
     */
     @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
     @JoinColumn(name = "info_order_id",referencedColumnName = "id")
     @JsonIgnore
     private InfoOrder infoOrder;

    /**
     * 订单状态:
     * OrderStatusEnum
     * ORDER_NONEPROCESS("未处理", 0),
     * ORDER_SUSSESS("支付成功", 1),
     * ORDER_FAIL("支付失败", 2),
     * ORDER_PROCESSING("处理中", 3),
     * ORDER_ERR("未知异常", 4);
     * ORDER_OVER("订单完成",5);
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(Long payerUserId) {
        this.payerUserId = payerUserId;
    }

    public Long getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(Long payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public BigDecimal getCapitalPayAmount() {
        return capitalPayAmount;
    }

    public void setCapitalPayAmount(BigDecimal capitalPayAmount) {
        this.capitalPayAmount = capitalPayAmount;
    }

     public InfoOrder getInfoOrder() {
         return infoOrder;
     }

    public void setInfoOrder(InfoOrder infoOrder) {
        this.infoOrder = infoOrder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
