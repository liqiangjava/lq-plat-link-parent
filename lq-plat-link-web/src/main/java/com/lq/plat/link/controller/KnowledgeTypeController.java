package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeTypePara;
import com.lq.plat.link.knowledge.KnowledgeType;
import com.lq.plat.link.service.KnowledgeTypeService;
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
 * @date 2017/7/3
 */
@RestController
@Api(value = "知识类型服务", description = "知识类型服务接口")
public class KnowledgeTypeController extends PlatformController {

    @Autowired
    private KnowledgeTypeService knowledgeTypeService;

    @ApiOperation(value = "知识类型信息查询", notes = "查询返回的结果")
    @GetMapping("admin/knowledgetypes/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getKnowledgetypes() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeTypeService.findAll());
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "用户信息更新", notes = "更新返回的结果")
    @PostMapping("admin/knowledgetypes")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateKnowledgetypes(
            @Valid @RequestBody final KnowledgeTypePara knowledgeTypePara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeTypeService.save(DTOUtils.map(knowledgeTypePara, KnowledgeType.class)));
                    }
                };

        return getWebAsyncTask(callable);
    }


}
