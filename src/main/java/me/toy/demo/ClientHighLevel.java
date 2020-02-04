package me.toy.demo;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
public class ClientHighLevel {

    RestHighLevelClient restHighLevelClient;

    public ClientHighLevel(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public IndexRequest request() {
        return new IndexRequest("spring-data-test", "doc")
                .source(Collections.singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
    }

    public IndexResponse response() {

        try {
            return restHighLevelClient.index(request(), RequestOptions.DEFAULT);
        } catch (Exception e) {

        }

        return null;
    }


}
