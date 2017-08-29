package com.lq.plat.link.common;

public class ResMsg {

  private String code;

  private String eMsg;

  public ResMsg() {

  }

  public ResMsg(String code) {

    this.code = code;
  }

  public ResMsg(String code, String eMsg) {

    this.code = code;
    this.eMsg = eMsg;
  }

  public String getCode() {

    return code;
  }

  public void setCode(String code) {

    this.code = code;
  }

  public String geteMsg() {

    return eMsg;
  }

  public void seteMsg(String eMsg) {

    this.eMsg = eMsg;
  }

}
