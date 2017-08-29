package com.lq.plat.link;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 平台认证失败处理类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/28
 */
public class PlatFormAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.getWriter().print(e.getMessage());
        final String origin = request.getHeader("origin");
        if (StringUtils.isNotEmpty(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        } else {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        response.setHeader("Access-Control-Allow-Headers",
                "content-type,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,serviceName,locale");
    }

}
