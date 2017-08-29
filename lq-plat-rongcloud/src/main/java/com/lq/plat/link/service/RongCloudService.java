package com.lq.plat.link.service;

import com.lq.plat.link.im.TokenResult;
import com.lq.plat.link.model.RongcloudTokenPara;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/14
 */
public interface RongCloudService {

    public TokenResult getToken( String name, String portraitUri) ;

}
