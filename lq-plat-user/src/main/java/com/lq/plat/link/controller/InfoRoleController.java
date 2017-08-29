package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.constant.PlatformConstants;
import com.lq.plat.link.security.InfoRole;
import com.lq.plat.link.service.InfoRoleService;
import com.lq.plat.link.user.InfoRolePara;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/6
 */
@RestController
@Api(value = "用户角色服务", description = "用户角色信息接口")
public class InfoRoleController extends PlatformController {

    @Autowired
    private InfoRoleService infoRoleService;


    @ApiOperation(value = "用户信息查询", notes = "查询用户返回的结果")
    @GetMapping("admin/inforoles")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = InfoRole.class),
            @ApiResponse(code = PlatformConstants.API_RESPONSE_FALSE_CODE, message = PlatformConstants.API_RESPONSE_FALSE_MESSAGE, response = PlatformResult.class)
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> getInfoRoles() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(infoRoleService.findAll());
                    }
                };
        return getWebAsyncTask(callable);
    }


    @ApiOperation(value = "用户信息注册", notes = "用户注册返回的结果")
    @PostMapping("admin/inforoles")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = PlatformResult.class),
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> saveInfoRoles(
            @Valid @RequestBody final InfoRolePara infoRolePara, final BindingResult result
    ) {
        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        // 判断result是否报错
                        if (result.hasErrors()) {
                            return ApiUtils.validError(result);
                        }
                        InfoRole infoRole = DTOUtils.map(infoRolePara, InfoRole.class);
                        return ApiUtils.ok(infoRoleService.save(infoRole));
                    }
                };
        return getWebAsyncTask(callable);
    }

}
