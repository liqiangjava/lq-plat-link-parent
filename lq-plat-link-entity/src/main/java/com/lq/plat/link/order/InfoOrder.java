package com.lq.plat.link.order;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoOrder extends BaseEntity {

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
     * 金账号支付金额
     */
    private BigDecimal capitalPayAmount = BigDecimal.ZERO;

    /**
     * 订单状态:
     ORDER_NONEPROCESS("未处理", 0),
     ORDER_SUSSESS("支付成功", 1),
     ORDER_FAIL("支付失败", 2),
     ORDER_PROCESSING("处理中", 3),
     ORDER_ERR("未知异常", 4);
     */
    private Integer status;


    public InfoOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCapitalPayAmount() {
        return capitalPayAmount;
    }

    public void setCapitalPayAmount(BigDecimal capitalPayAmount) {
        this.capitalPayAmount = capitalPayAmount;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
