package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.service.HotWordService;
import com.lq.plat.link.system.HotWordPara;
import com.lq.plat.link.system.SysHotWord;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @date 2017/7/4
 */
@RestController
@Api(value = "热词信息服务", description = "热词信息接口")
public class HotWordController extends PlatformController {

    @Autowired
    private HotWordService hotWordService;

    @ApiOperation(value = "知识类型信息查询", notes = "查询返回的结果")
    @GetMapping("admin/hotwords/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getHotWord() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(hotWordService.findAll());
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "热词信息增加", notes = "增加数据返回的结果")
    @PostMapping("admin/hotwords")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateHotWord(
            @Valid @RequestBody final HotWordPara hotWordPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(hotWordService.save(DTOUtils.map(hotWordPara, SysHotWord.class)));
                    }
                };

        return getWebAsyncTask(callable);
    }

}
