package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeAnswerPara;
import com.lq.plat.link.service.KnowledgeAnswerService;
import com.lq.plat.link.utils.ApiUtils;
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
 * 知识点答案控制类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
@RestController
@Api(value = "知识点答案服务", description = "知识点答案服务接口")
public class KnowledgeAnswerController extends PlatformController {

    @Autowired
    private KnowledgeAnswerService knowledgeAnswerService;

    @ApiOperation(value = "知识答案添加", notes = "添加返回的结果")
    @PostMapping("admin/knowledgeanswers/{id}")
    public WebAsyncTask<ResponseEntity<PlatformResult>> addKnowledgeQuestions(@PathVariable final Long id,
            @Valid @RequestBody final KnowledgeAnswerPara knowledgeAnswerPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeAnswerService.save(knowledgeAnswerPara,id));
                    }
                };

        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "月最佳回答者查询", notes = "查询月最佳回答者的结果")
    @GetMapping("admin/knowledgeanswers/month/bestresponder")
    public WebAsyncTask<ResponseEntity<PlatformResult>> monthBestInfouser(@ApiParam("多少条") @RequestParam("size") Integer size) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeAnswerService.monthBestResponder(size));
                    }
                };

        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "更新答案信息", notes = "添加返回的结果")
    @PutMapping("admin/knowledgeanswers")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateKnowledgeQuestions(
                                                                              @Valid @RequestBody final KnowledgeAnswerPara knowledgeAnswerPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeAnswerService.update(knowledgeAnswerPara));
                    }
                };

        return getWebAsyncTask(callable);
    }


    @ApiOperation(value = "设置为最佳答案", notes = "添加返回的结果")
    @PutMapping("admin/knowledgeanswers/bestAnswers/{answerId}/{questionId}")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateKnowledgeQuestionsBestAnswers(@ApiParam("答案ID") @PathVariable final Long answerId,
                                                                                            @ApiParam("问题ID") @PathVariable final Long questionId,final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeAnswerService.updateKnowledgeQuestionsBestAnswers(answerId,questionId));
                    }
                };

        return getWebAsyncTask(callable);
    }

}
