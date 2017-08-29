package com.lq.plat.link.service.impl;

import com.lq.plat.link.common.Constant;
import com.lq.plat.link.im.GsonUtil;
import com.lq.plat.link.im.TokenResult;
import com.lq.plat.link.model.RongcloudTokenPara;
import com.lq.plat.link.service.RongCloudService;
import com.lq.plat.link.util.HostType;
import com.lq.plat.link.util.HttpUtil;
import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/14
 */
@Service
public class RongCloudServiceImpl implements RongCloudService {


    @Value("${rongyun.appkey}")
    private String rongCloudAppKey;

    @Value("${rongyun.appsecret}")
    private String rongCloudAppSecret;


    @Override
    public TokenResult getToken(String name, String portraitUri) {
        try {
            Long userId = UserSecurityUtils.getInfoUserId();
            StringBuilder sb = new StringBuilder();
            sb.append("&userId=").append(URLEncoder.encode(userId.toString(), Constant.UTF8));
            sb.append("&name=").append(URLEncoder.encode(name.toString(), Constant.UTF8));
            sb.append("&portraitUri=").append(URLEncoder.encode(portraitUri.toString(), Constant.UTF8));
            String body = sb.toString();
            if (body.indexOf("&") == 0) {
                body = body.substring(1, body.length());
            }

            HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(HostType.API, rongCloudAppKey, rongCloudAppSecret, "/user/getToken.json", "application/x-www-form-urlencoded");
            HttpUtil.setBodyParameter(body, conn);

            return (TokenResult) GsonUtil.fromJson(HttpUtil.returnResult(conn), TokenResult.class);
        } catch (Exception e) {
             e.printStackTrace();
            return null;
        }
    }


}