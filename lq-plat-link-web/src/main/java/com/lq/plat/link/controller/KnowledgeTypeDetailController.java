package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeTypeDetailPara;
import com.lq.plat.link.knowledge.KnowledgeTypeDetail;
import com.lq.plat.link.service.KnowledgeTypeDetailService;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
@RestController
@Api(value = "知识类型明细服务", description = "知识类型明细服务接口")
public class KnowledgeTypeDetailController extends PlatformController {

    @Autowired
    private KnowledgeTypeDetailService knowledgeTypeDetailService;

    @ApiOperation(value = "知识类型信息查询", notes = "查询返回的结果")
    @GetMapping("admin/knowledgetypedetails/{id}")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getKnowledgeTypeDetail(@ApiParam("ID") @PathVariable final Long id) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok();
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "用户信息更新", notes = "更新返回的结果")
    @PostMapping("admin/knowledgetypedetails/{id}")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateKnowledgeTypeDetail(@ApiParam("父类ID") @PathVariable final Long id,
                                                                       @Valid @RequestBody final KnowledgeTypeDetailPara knowledgeTypeDetailPara, final BindingResult result) {
        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(knowledgeTypeDetailService.save(DTOUtils.map(knowledgeTypeDetailPara, KnowledgeTypeDetail.class),id));
                    }
                };

        return getWebAsyncTask(callable);
    }


}
