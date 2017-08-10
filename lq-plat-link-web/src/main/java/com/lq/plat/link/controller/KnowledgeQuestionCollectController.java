package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeQuestionCollectPara;
import com.lq.plat.link.knowledge.KnowledgeQuestionCollect;
import com.lq.plat.link.service.KnowledgeQuestionCollectService;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * 知识点答案控制类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
@RestController
@Api(value = "收藏问题服务", description = "收藏问题服务接口")
public class KnowledgeQuestionCollectController extends PlatformController {

    @Autowired
    private KnowledgeQuestionCollectService knowledgeQuestionCollectService;

    @ApiOperation(value = "收藏问题添加", notes = "添加返回的结果")
    @PostMapping("admin/knowledgequestioncollects")
    public WebAsyncTask<ResponseEntity<PlatformResult>> collectQuestions(
            @Valid @RequestBody final KnowledgeQuestionCollectPara knowledgeQuestionCollectPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        KnowledgeQuestionCollect questionCollect = DTOUtils.map(knowledgeQuestionCollectPara, KnowledgeQuestionCollect.class);
                        return ApiUtils.ok(knowledgeQuestionCollectService.save(questionCollect));
                    }
                };

        return getWebAsyncTask(callable);
    }




}
