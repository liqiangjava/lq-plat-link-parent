package com.lq.plat.link.knowledage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 最佳回答者
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/26
 */
public class BestResponderDto {

    @ApiModelProperty(value = "收款者ID")
    private Long payeeUserId;

    //收款者用户名
    @ApiModelProperty(value = "收款者用户名")
    private String  payeeUsername;

    //收款者头像
    @ApiModelProperty(value = "收款者头像")
    private String payeePortrait;

    //收款者手机号
    @ApiModelProperty(value = "收款者手机号")
    private String payeeMobile;

    //收款者邮箱
    @ApiModelProperty(value = "收款者邮箱")
    private String payeeEmail;

    //收款者账户名称（方便查找对应账户信息）
    @ApiModelProperty(value = "收款者账户名称")
    private String payeeAccountName;

    //收款二维码
    @ApiModelProperty(value = "收款者二维码")
    private String payeeReceivablesQrcode;

    //付款者名称
    @ApiModelProperty(value = "付款者名称")
    private String payerUsername;

    @ApiModelProperty(value = "付款者ID")
    private Long  payerUserId;

    //付款者金额
    @ApiModelProperty(value = "付款者金额")
    private BigDecimal payerPrice;

    @ApiModelProperty(value = "付款者问题标题")
    private String payerQuestionTitle;

    @ApiModelProperty(value = "付款者账户名称")
    private String payerAccountName;

    public String getPayeeUsername() {
        return payeeUsername;
    }

    public void setPayeeUsername(String payeeUsername) {
        this.payeeUsername = payeeUsername;
    }

    public String getPayeePortrait() {
        return payeePortrait;
    }

    public void setPayeePortrait(String payeePortrait) {
        this.payeePortrait = payeePortrait;
    }

    public String getPayeeMobile() {
        return payeeMobile;
    }

    public void setPayeeMobile(String payeeMobile) {
        this.payeeMobile = payeeMobile;
    }

    public String getPayeeEmail() {
        return payeeEmail;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }

    public String getPayeeAccountName() {
        return payeeAccountName;
    }

    public void setPayeeAccountName(String payeeAccountName) {
        this.payeeAccountName = payeeAccountName;
    }

    public String getPayeeReceivablesQrcode() {
        return payeeReceivablesQrcode;
    }

    public void setPayeeReceivablesQrcode(String payeeReceivablesQrcode) {
        this.payeeReceivablesQrcode = payeeReceivablesQrcode;
    }

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

    public String getPayerAccountName() {
        return payerAccountName;
    }

    public void setPayerAccountName(String payerAccountName) {
        this.payerAccountName = payerAccountName;
    }



}
