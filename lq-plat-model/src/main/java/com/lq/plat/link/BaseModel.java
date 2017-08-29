package com.lq.plat.link;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public class BaseModel {

    @ApiModelProperty(value = "数据标签 0 是测试,1是正式")
    private Integer dataSign;

    public Integer getDataSign() {
        return dataSign;
    }

    public void setDataSign(Integer dataSign) {
        this.dataSign = dataSign;
    }
}
