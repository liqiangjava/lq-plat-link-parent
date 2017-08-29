package com.lq.plat.link.controller;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/16
 */
public class ElasticsearchAggrController {

    public static void main(String[] args) throws Exception {
        // 先构建client
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        SearchResponse searchResponse = client.prepareSearch("company")
                .addAggregation(AggregationBuilders.terms("group_by_country")
                        .field("country")
                        .subAggregation(
                                AggregationBuilders
                                        .dateHistogram("group_by_join_date")
                                        .field("join_date")
                                        .dateHistogramInterval(
                                                DateHistogramInterval.YEAR
                                        ).subAggregation(AggregationBuilders.avg("avg_salary").field("salary"))
                        )
                ).execute().actionGet();

        List<Aggregation> aggrList = searchResponse.getAggregations().asList();
        client.close();

    }

}
