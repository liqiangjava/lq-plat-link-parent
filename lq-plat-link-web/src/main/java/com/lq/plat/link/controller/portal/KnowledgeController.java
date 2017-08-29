package com.lq.plat.link.controller.portal;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeQuestionPara;
import com.lq.plat.link.knowledage.KnowledgeQuestionUpdatePara;
import com.lq.plat.link.service.InfoOrderService;
import com.lq.plat.link.service.KnowledgeAnswerService;
import com.lq.plat.link.service.KnowledgeQuestionService;
import com.lq.plat.link.utils.ApiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.concurrent.Callable;

/**
 * 后台：知识相关
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/9
 */
@RestController
@Api(value = "后台_知识相关服务", description = "后台_知识相关接口")
public class KnowledgeController extends PlatformController {

    @Autowired
    private KnowledgeQuestionService knowledgeQuestionService;

    @Autowired
    private KnowledgeAnswerService knowledgeAnswerService;

    @Autowired
    private InfoOrderService infoOrderService;

    //查询最佳回答者
    @ApiOperation(value = "查询待发布的问题", notes = "查询返回的结果")
    @GetMapping("manage/knowledgequestions/tobeannounced")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getTBAKnowledgeQuestions( @PageableDefault final Pageable pageable) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(knowledgeQuestionService.getTBAKnowledgeQuestions(pageable));
                    }
                };
        return getWebAsyncTask(callable);
    }

    //当确认收到钱之后，后台将该问题状态设为已发布
    @ApiOperation(value = "更新答案信息:当确认收到钱之后，后台将该问题状态设为已发布", notes = "添加返回的结果")
    @PutMapping("manage/knowledgequestions")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateInfoAccounts(
            @Valid @RequestBody final KnowledgeQuestionUpdatePara knowledgeQuestionUpdatePara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeQuestionService.update(knowledgeQuestionUpdatePara));
                    }
                };

        return getWebAsyncTask(callable);
    }

    //查询最佳回答者
    @ApiOperation(value = "查询最佳回答者", notes = "查询返回的结果")
    @GetMapping("manage/knowledgeanswers/bestAnswers")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getBestAnswers( @PageableDefault final Pageable pageable) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(knowledgeAnswerService.findBestAnswer(pageable));
                    }
                };
        return getWebAsyncTask(callable);
    }

    //给最佳回答者打款，将订单状态设为结束
    @ApiOperation(value = "给最佳回答者打款，将订单状态设为结束", notes = "添加返回的结果")
    @PostMapping("manage/bestAnswers/payee/{orderid}/{payeeuserid}")
    public WebAsyncTask<ResponseEntity<PlatformResult>> bestAnswersPayee(@ApiParam("订单ID") @PathVariable final Long orderid,
                                                                         @ApiParam("收款者ID") @PathVariable final Long      payeeuserid,
            @Valid @RequestBody final KnowledgeQuestionPara knowledgeQuestionPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(infoOrderService.bestAnswersPayee(orderid,payeeuserid))
                        ;
                    }
                };

        return getWebAsyncTask(callable);
    }

}
