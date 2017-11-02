package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.account.InfoAccountPara;
import com.lq.plat.link.service.InfoAccountService;
import com.lq.plat.link.utils.ApiUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * 账户信息
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/10
 */
public class InfoAccountController extends PlatformController {

    @Autowired
    private InfoAccountService infoAccountService;

    //创建问题时，提示用户完善信息，更新方法
    @ApiOperation(value = "更新答案信息", notes = "添加返回的结果")
    @PutMapping("admin/infoaccounts")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateInfoAccounts(
            @Valid @RequestBody final InfoAccountPara infoAccountPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(infoAccountService.update(infoAccountPara));
                    }
                };

        return getWebAsyncTask(callable);
    }





}
