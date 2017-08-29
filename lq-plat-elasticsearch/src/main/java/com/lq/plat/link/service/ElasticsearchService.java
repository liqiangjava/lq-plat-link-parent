package com.lq.plat.link.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lq.plat.link.elasticsearch.Elasticsearch;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/28
 */
public interface ElasticsearchService {


    JSONObject findData(Elasticsearch elasticsearch);

}
