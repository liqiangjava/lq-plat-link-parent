package com.lq.plat.link.controller;

import java.net.InetAddress;
import java.util.concurrent.Callable;

import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.elasticsearch.Elasticsearch;
import com.lq.plat.link.elasticsearch.ElasticsearchPara;
import com.lq.plat.link.service.ElasticsearchService;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;

/**
 * 员工增删改查的应用程序
 *
 * @author Administrator
 */
@RestController
@Api(value = "搜索服务", description = "搜索接口")
public class ElasticsearchController extends PlatformController {

    @Autowired
    private ElasticsearchService elasticsearchService;


    //@ApiOperation(value = "搜索查询", notes = "查询返回的结果")
    //@GetMapping("admin/elasticsearch/info")
    public WebAsyncTask<ResponseEntity<PlatformResult>> getElasticsearch(@Valid @RequestBody final ElasticsearchPara elasticsearchPara) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {
                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        return ApiUtils.ok(elasticsearchService.findData(DTOUtils.map(elasticsearchPara, Elasticsearch.class)));
                    }
                };
        return getWebAsyncTask(callable);
    }


}
