package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/9
 */
public class PayeeDto {

    //收款者用户名
    @ApiModelProperty(value = "收款者用户名")
    private String  payeeUsername;

    //收款者头像
    @ApiModelProperty(value = "收款者头像")
    private String payeePortrait;


    //收款者手机号
    @ApiModelProperty(value = "手机号")
    private String payeeMobile;

    //收款者邮箱
    @ApiModelProperty(value = "邮箱")
    private String payeeEmail;

    //收款者账户名称（方便查找对应账户信息）
    @ApiModelProperty(value = "收款者账户名称")
    private String payeeAccountName;

    //收款二维码
    @ApiModelProperty(value = "收款者二维码")
    private String payeeReceivablesQrcode;


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
}
