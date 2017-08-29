package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.knowledage.KnowledgeQuestionPara;
import com.lq.plat.link.knowledge.KnowledgeQuestion;
import com.lq.plat.link.service.KnowledgeQuestionService;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
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
 * 知识问题控制类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/7
 */
@RestController
@Api(value = "知识点问题服务", description = "知识点问题服务接口")
public class KnowledgeQuestionController extends PlatformController {

    @Autowired
    private KnowledgeQuestionService knowledgeQuestionService;

    @ApiOperation(value = "知识问题添加", notes = "添加返回的结果")
    @PostMapping("admin/knowledgequestions")
    public WebAsyncTask<ResponseEntity<PlatformResult>> addKnowledgeQuestions(
            @Valid @RequestBody final KnowledgeQuestionPara knowledgeQuestionPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {

                        return ApiUtils.ok(knowledgeQuestionService.save(DTOUtils.map(knowledgeQuestionPara, KnowledgeQuestion.class))
                        );
                    }
                };

        return getWebAsyncTask(callable);
    }


    //涉及分页
    @ApiOperation(value = "知识问题所有信息查询", notes = "查询返回的结果")
    @GetMapping("admin/knowledgequestions/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getKnowledgeQuestion(
            @RequestParam(value = "title",
                    required = false) final String title, @ApiParam("分页sort表示排序:属性+逗号+asc/desc,如:sort=title&sort=createDate,desc&page=0&size=10")  @PageableDefault final Pageable pageable) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        KnowledgeQuestion knowledgeQuestion = new KnowledgeQuestion();
                        knowledgeQuestion.setTitle(title);
                        return ApiUtils.ok(
                                knowledgeQuestionService.queryKnowledgeQuestion(knowledgeQuestion, pageable)
                        );
                    }
                };
        return getWebAsyncTask(callable);
    }

    //涉及分页
    @ApiOperation(value = "当前用户知识问题信息查询", notes = "查询返回的结果")
    @GetMapping("admin/knowledgequestions/currentuser")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getInfoUserByCus(@RequestParam(value = "title",
            required = false) final String title, @PageableDefault final Pageable pageable) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        Long userId = UserSecurityUtils.getInfoUserId();
                        return ApiUtils.ok(knowledgeQuestionService.queryCurrentUserKnowledgeQuestion(title,userId, pageable));
                    }
                };
        return getWebAsyncTask(callable);
    }




}
