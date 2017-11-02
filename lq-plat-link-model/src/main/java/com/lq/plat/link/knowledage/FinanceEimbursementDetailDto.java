package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 李强
 * @brief 概要描述
 * @details 详细描述
 * @date 2017年10月20日
 */
public class FinanceEimbursementDetailDto {

    @ApiModelProperty(value = "付款项目")
    private String payItem;

    //价格
    @ApiModelProperty(name = "付款金额")
    private BigDecimal price;


    public String getPayItem() {
        return payItem;
    }

    public void setPayItem(String payItem) {
        this.payItem = payItem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
