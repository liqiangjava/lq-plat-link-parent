package com.lq.plat.link.account;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
public class InfoAccountPara {


    //账户类型
    private Integer type;

    //账户名称（方便查找对应账户信息）
    private String name;

    //收款二维码
    private String receivablesQrcode;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceivablesQrcode() {
        return receivablesQrcode;
    }

    public void setReceivablesQrcode(String receivablesQrcode) {
        this.receivablesQrcode = receivablesQrcode;
    }
}
