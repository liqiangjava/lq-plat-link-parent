package com.lq.plat.link.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/14
 */
public class RongcloudTokenPara {


    // userId:用户        Id，最大长度 64 字节.是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private String userId;
    // name:用户名称，最大长度   128 字节.用来在 Push 推送时显示用户的名称.用户名称，最大长度 128 字节.用来在 Push 推送时显示用户的名称。（必传）
    @ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空")
    private String name;
    // portraitUri:用户头像 URI，最大长度 1024 字节.用来在 Push 推送时显示用户的头像。（必传）
    @ApiModelProperty(value = "用户头像")
    @NotNull(message = "用户头像不能为空")
    private String portraitUri;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }
}
