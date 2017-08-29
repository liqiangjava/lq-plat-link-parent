package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.service.RongCloudService;
import com.lq.plat.link.utils.ApiUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/20
 */
@RestController
@Api(value = "融云服务", description = "融云服务接口")
public class RongCloudController extends PlatformController {

    @Autowired
    private RongCloudService rongCloudService;

    /**
     * 获取 Token 方法
     *
     * @return TokenResult
     **/
    @ApiOperation(value = "即使通信token查询", notes = "查询即时通信token的结果")
    @GetMapping("admin/rongcloud/token")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getToken( @ApiParam("用户名称") @RequestParam(value = "name",
            required = true) final String name, @ApiParam("用户头像") @RequestParam(value = "portraitUri",
            required = true) final String portraitUri) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(rongCloudService.getToken(name, portraitUri));
                    }
                };
        return getWebAsyncTask(callable);
    }

}
