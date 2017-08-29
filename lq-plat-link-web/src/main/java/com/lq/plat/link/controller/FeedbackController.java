package com.lq.plat.link.controller;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.service.FeedbackService;
import com.lq.plat.link.system.FeedbackPara;
import com.lq.plat.link.system.SysFeedback;
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
@Api(value = "反馈信息服务", description = "反馈信息接口")
public class FeedbackController extends PlatformController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "反馈信息查询", notes = "查询返回的结果")
    @GetMapping("admin/feedbacks/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getFeedback() {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(feedbackService.findAll());
                    }
                };
        return getWebAsyncTask(callable);
    }

    @ApiOperation(value = "反馈信息增加", notes = "增加数据返回的结果")
    @PostMapping("admin/feedbacks")
    public WebAsyncTask<ResponseEntity<PlatformResult>> updateFeedback(
            @Valid @RequestBody final FeedbackPara feedbackPara, final BindingResult result) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        // 判断result是否报错
                        if (result.hasErrors()) {
                            return ApiUtils.validError(result);
                        }
                        return ApiUtils.ok(feedbackService.save(DTOUtils.map(feedbackPara, SysFeedback.class)));
                    }
                };

        return getWebAsyncTask(callable);
    }

}
