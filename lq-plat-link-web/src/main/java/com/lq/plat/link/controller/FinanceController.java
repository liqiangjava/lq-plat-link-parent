package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.service.FinanceService;
import com.lq.plat.link.utils.ApiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author 李强
 * @brief 概要描述
 * @details 详细描述
 * @date 2017年10月20日
 */
@RestController
@Api(value = "财务信息服务", description = "财务信息接口")
public class FinanceController  extends PlatformController {

    @Autowired
    private FinanceService financeService;

    @ApiOperation(value = "费用报销付款信息查询", notes = "查询返回的结果")
    @GetMapping("admin/finances/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getFeedback() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(financeService.findAll());
                    }
                };
        return getWebAsyncTask(callable);
    }


}
