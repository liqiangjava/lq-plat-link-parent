package com.lq.plat.link.Controller;


import com.alibaba.fastjson.JSONObject;
import com.lq.plat.link.PlatformResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class PlatformController {

    /**
     * 异步返回
     * @param callable
     * @return
     */
    public WebAsyncTask<ResponseEntity<PlatformResult>> getWebAsyncTask(Callable<ResponseEntity<PlatformResult>> callable) {

        return new WebAsyncTask<ResponseEntity<PlatformResult>>(callable);

    }

    /**
     * 输出Json字符串
     *  @param response
     * @param result
     */
    protected void writeJsonString(HttpServletResponse response, JSONObject result) {

        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Cache-Control", "no-store");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(result.toJSONString());
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            pw.write("[]");
            pw.flush();
        }

    }

}
