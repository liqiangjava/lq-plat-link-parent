package com.lq.plat.link.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.ConstantParaUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/1
 */
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

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
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<PlatformResult> responseEntity = ApiUtils.ok(ConstantParaUtil.SUCCESS_LOGIN);
        mapper.writeValue(response.getWriter(), responseEntity);

        /*
        response.setHeader("Cache-Control", "no-store");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            Map<String,String> map = new HashMap<String,String>();
            map.put("code","200");
            map.put("message","登录成功");
            pw.write(JSON.toJSONString(map));
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            pw.write("[]");
            pw.flush();
        }*/

        //handle(request, response, authentication);
        //clearAuthenticationAttributes(request);
    }
}
