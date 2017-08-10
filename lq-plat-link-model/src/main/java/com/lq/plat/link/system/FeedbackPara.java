package com.lq.plat.link.system;

import com.lq.plat.link.BaseModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/4
 */
public class FeedbackPara extends BaseModel {

    //名称
    @ApiModelProperty("名称")
    private String name;
    //联系方式
    @ApiModelProperty(value = "联系方式")
    private String contactInfo;
    //内容
    @ApiModelProperty(value = "内容")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
