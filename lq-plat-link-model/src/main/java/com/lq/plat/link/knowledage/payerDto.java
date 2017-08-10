package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/9
 */
public class payerDto {
    //付款者名称
    @ApiModelProperty(value = "付款者名称")
    private String payerUsername;

    //付款者金额
    @ApiModelProperty(value = "付款者金额")
    private BigDecimal payerPrice;

    @ApiModelProperty(value = "付款者问题标题")
    private String payerQuestionTitle;

    public String getPayerUsername() {
        return payerUsername;
    }

    public void setPayerUsername(String payerUsername) {
        this.payerUsername = payerUsername;
    }

    public BigDecimal getPayerPrice() {
        return payerPrice;
    }

    public void setPayerPrice(BigDecimal payerPrice) {
        this.payerPrice = payerPrice;
    }

    public String getPayerQuestionTitle() {
        return payerQuestionTitle;
    }

    public void setPayerQuestionTitle(String payerQuestionTitle) {
        this.payerQuestionTitle = payerQuestionTitle;
    }
}
