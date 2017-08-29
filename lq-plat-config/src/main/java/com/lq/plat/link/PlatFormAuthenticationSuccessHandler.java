package com.lq.plat.link;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/28
 */
public class PlatFormAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * 认证成功后要做的事情
     *
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //System.out.println("111111111"+(UserDetails) authentication.getPrincipal());
       // SecurityContextHolder.getContext().setAuthentication(authentication);


        final String origin = request.getHeader("origin");
        if (StringUtils.isNotEmpty(origin))
        {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }
        else
        {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        response.setHeader("Access-Control-Allow-Headers",
                "content-type,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,serviceName,locale");

       // super.onAuthenticationSuccess(request, response, authentication);
    }
}

