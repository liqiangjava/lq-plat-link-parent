package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.PlatformStatus;
import com.lq.plat.link.utils.ApiUtils;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * 权限认证控制器
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/13
 */
@RestController
@Api(value = "权限认证服务", description = "权限认证服务接口")
public class SecurityController extends PlatformController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private String loginPageUrl = "/login.html";

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public WebAsyncTask<ResponseEntity<PlatformResult>> requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        try {
                            SavedRequest savedRequest = requestCache.getRequest(request, response);
                            /*if (savedRequest != null) {
                                String targetUrl = savedRequest.getRedirectUrl();
                                Long userId = UserSecurityUtils.getInfoUserId();
                                if (userId != null && !userId.equals("")) {
                                    redirectStrategy.sendRedirect(request, response, targetUrl);
                                }
                            }*/
                            if (savedRequest != null) {
                                String targetUrl = savedRequest.getRedirectUrl();
                                if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                                    redirectStrategy.sendRedirect(request, response, loginPageUrl);
                                }
                            }
                        } catch (Exception e) {
                            return ApiUtils.error(PlatformStatus.S40001);
                        }
                        return ApiUtils.error(PlatformStatus.S40001);
                    }
                };

        return getWebAsyncTask(callable);
    }


}
