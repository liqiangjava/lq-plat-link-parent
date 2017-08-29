package com.lq.plat.link.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lq.plat.link.elasticsearch.Elasticsearch;
import com.lq.plat.link.service.ElasticsearchService;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/28
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService{

    public static TransportClient client;


    public static void initESClient() throws Exception {
        // 先构建client
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();

        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        //createEmployee(client);
        //getEmployee(client);
        //	updateEmployee(client);
        // deleteEmployee(client);

        //client.close();

    }

    @Override
    public JSONObject findData(Elasticsearch elasticsearch) {
        SearchResponse response = client.prepareSearch(elasticsearch.getIndex())
                .setTypes(elasticsearch.getType())
                .setQuery(QueryBuilders.matchQuery(elasticsearch.getField(), elasticsearch.getData()))
                //.setPostFilter(QueryBuilders.rangeQuery("age").from(30).to(40))
                //.setFrom(0).setSize(1)
                .get();

        SearchHit[] searchHits = response.getHits().getHits();
        for(int i = 0; i < searchHits.length; i++) {
            System.out.println(searchHits[i].getSourceAsString());
        }
        return null;
    }




    public static void closeESClient() {
        if (client != null)
            client.close();
    }

    /**
     * 创建员工信息（创建一个document）
     *
     * @param client
     */
    private static void createEmployee(TransportClient client) throws Exception {
        IndexResponse response = client.prepareIndex("company", "employee", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "jack")
                        .field("age", 27)
                        .field("position", "technique")
                        .field("country", "china")
                        .field("join_date", "2017-01-01")
                        .field("salary", 10000)
                        .endObject())
                .get();
        System.out.println(response.getResult());
    }

    /**
     * 获取员工信息
     *
     * @param client
     * @throws Exception
     */
    private static void getEmployee(TransportClient client) throws Exception {
        GetResponse response = client.prepareGet("company", "employee", "1").get();
        System.out.println(response.getSourceAsString());
    }

    /**
     * 修改员工信息
     *
     * @param client
     * @throws Exception
     */
    private static void updateEmployee(TransportClient client) throws Exception {
        UpdateResponse response = client.prepareUpdate("company", "employee", "1")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("position", "technique manager")
                        .endObject())
                .get();
        System.out.println(response.getResult());
    }

    /**
     * 删除 员工信息
     *
     * @param client
     * @throws Exception
     */
    private static void deleteEmployee(TransportClient client) throws Exception {
        DeleteResponse response = client.prepareDelete("company", "employee", "1").get();
        System.out.println(response.getResult());
    }
}
