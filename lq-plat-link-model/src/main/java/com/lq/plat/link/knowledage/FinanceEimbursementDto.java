package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李强
 * @brief 概要描述
 * @details 详细描述
 * @date 2017年10月20日
 */
public class FinanceEimbursementDto {

    @ApiModelProperty(value = "付款项目详情")
    private List<FinanceEimbursementDetailDto> financeEimbursementDetailDtos;

    @ApiModelProperty(value = "合计金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "大写合计金额")
    private String ChTotalPrice;

    @ApiModelProperty(value = "收款人开户行")
    private String openingBank;

    @ApiModelProperty(value = "收款人账号")
    private String bankAccount;

    @ApiModelProperty(value = "付款日期")
    private Date payTime;


    public List<FinanceEimbursementDetailDto> getFinanceEimbursementDetailDtos() {
        return financeEimbursementDetailDtos;
    }

    public void setFinanceEimbursementDetailDtos(List<FinanceEimbursementDetailDto> financeEimbursementDetailDtos) {
        this.financeEimbursementDetailDtos = financeEimbursementDetailDtos;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getChTotalPrice() {
        return ChTotalPrice;
    }

    public void setChTotalPrice(String chTotalPrice) {
        ChTotalPrice = chTotalPrice;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
