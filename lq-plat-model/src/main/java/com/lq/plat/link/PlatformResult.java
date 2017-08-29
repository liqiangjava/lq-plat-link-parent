package com.lq.plat.link;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class PlatformResult {

    @ApiModelProperty(value = "错误码,0为成功,-1为失败")
    private int errCode;
    @ApiModelProperty(value = "错误信息")
    private String errMsg;
    @ApiModelProperty(value = "返回数据")
    private Object data;

    public static PlatformResult custom()
    {
        PlatformResult wb = new PlatformResult();
        return wb;
    }

    public PlatformResult validError()
    {
        this.errCode = -1;
        return this;
    }

    public PlatformResult setErrCode(int errCode)
    {
        this.errCode = errCode;
        return this;
    }

    public PlatformResult setData(Object data)
    {
        this.data = data;
        return this;
    }

    public int getErrCode()
    {
        return this.errCode;
    }

    public Object getData()
    {
        return this.data;
    }

    public String getErrMsg()
    {
        return this.errMsg;
    }

    public PlatformResult setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
        return this;
    }

    public String toString()
    {
        return "PlatformResult [errCode=" + this.errCode + ", data=" + this.data + "]";
    }
}
