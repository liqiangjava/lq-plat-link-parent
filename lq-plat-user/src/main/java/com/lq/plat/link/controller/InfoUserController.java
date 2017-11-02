package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.PlatformStatus;
import com.lq.plat.link.constant.PlatformConstants;
import com.lq.plat.link.service.InfoUserService;
import com.lq.plat.link.user.InfoUserDto;
import com.lq.plat.link.user.InfoUserPara;
import com.lq.plat.link.user.PlatFormInfoUserPara;
import com.lq.plat.link.user.PlatFormInfoUserSignUpPara;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.ConstantParaUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/25
 */
@RestController
@Api(value = "用户信息服务", description = "用户信息接口")
public class InfoUserController extends PlatformController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(InfoUserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private InfoUserService infoUserService;

    @ApiOperation(value = "用户信息查询", notes = "查询用户返回的结果")
    @GetMapping("admin/infousers/info")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = InfoUserDto.class),
            @ApiResponse(code = PlatformConstants.API_RESPONSE_FALSE_CODE, message = PlatformConstants.API_RESPONSE_FALSE_MESSAGE, response = PlatformResult.class)
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> getInfoUser() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(infoUserService.findOne());
                    }
                };
        return getWebAsyncTask(callable);
    }


    @ApiOperation(value = "用户信息注册", notes = "用户注册返回的结果")
    @PostMapping("admin/infousers/signup")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> saveInfoUser(
            @RequestBody final PlatFormInfoUserSignUpPara platFormInfoUserSignUpPara, final BindingResult result) {
        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        // 判断result是否报错
                        if (result.hasErrors()) {
                            return ApiUtils.validError(result);
                        }
                        if (!platFormInfoUserSignUpPara.getPassword1().equals(platFormInfoUserSignUpPara.getPassword2())) {
                            return ApiUtils.error(ConstantParaUtil.PASSWORD_NOT_MATCH);
                        }
                        return infoUserService.save(platFormInfoUserSignUpPara.getUsername(), platFormInfoUserSignUpPara.getPassword1(), platFormInfoUserSignUpPara.getModel());
                    }
                };
        return getWebAsyncTask(callable);
    }


   /* @ApiOperation(value = "用户信息登入", notes = "用户登入返回的结果")
    @GetMapping("admin/infousers/login")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> loginPage(@RequestParam String username,
                                                                  @RequestParam String password, HttpServletRequest request) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        try {
                            //request.setAttribute("rememberMe", true);
                            String newPassword = password;
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, newPassword);
                            Authentication authentication = authenticationManager.authenticate(token);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            HttpSession session = request.getSession();
                            // 这个非常重要，否则验证后将无法登陆
                            session.setAttribute(ConstantParaUtil.SPRING_SECURITY_CONTEXT, SecurityContextHolder.getContext());
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage());
                            return ApiUtils.error(PlatformStatus.S41001);
                        }
                        return ApiUtils.ok(ConstantParaUtil.SUCCESS_LOGIN);
                    }
                };
        return getWebAsyncTask(callable);
    }*/

    @ApiOperation(value = "用户信息登入", notes = "用户登入返回的结果")
    @PostMapping("admin/infousers/login")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> login(@RequestBody final PlatFormInfoUserPara platFormInfoUserPara, HttpServletRequest request, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        // 判断result是否报错
                        if (result.hasErrors()) {
                            return ApiUtils.validError(result);
                        }
                        try {
                            //request.setAttribute("rememberMe", true);
                            String newPassword = platFormInfoUserPara.getPassword();
                            String username = platFormInfoUserPara.getUsername();
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, newPassword);
                            Authentication authentication = authenticationManager.authenticate(token);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            HttpSession session = request.getSession();
                            // 这个非常重要，否则验证后将无法登陆
                            session.setAttribute(ConstantParaUtil.SPRING_SECURITY_CONTEXT, SecurityContextHolder.getContext());
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage());
                            return ApiUtils.error(PlatformStatus.S41001);
                        }
                        return ApiUtils.ok(ConstantParaUtil.SUCCESS_LOGIN);
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "用户信息登出", notes = "用户登出返回的结果")
    @GetMapping("admin/infousers/logout")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> logoutPage(HttpServletRequest request, HttpServletResponse response) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                        if (auth != null) {
                            new SecurityContextLogoutHandler().logout(request, response, auth);
                        }
                        return ApiUtils.ok(ConstantParaUtil.SUCCESS_LOGOUT);
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "用户信息更新", notes = "更新返回的结果")
    @PutMapping("admin/infousers")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateInfoUser(
            @Valid @RequestBody final InfoUserPara infoUserPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(infoUserService.update(infoUserPara));
                    }
                };

        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "用户信息删除", notes = "删除用户信息返回的结果")
    @DeleteMapping("/admin/infousers")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> removeInfoUser() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        infoUserService.remove();
                        return ApiUtils.deleted();
                    }
                };

        return getWebAsyncTask(callable);
    }


}
