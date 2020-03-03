package me.toy.demo;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "me.toy.demo")
public class Config {

    @Value("${elasticsearch.host}")
    String ES_Host;

    @Value("${elasticsearch.tcp-port}")
    Integer ES_TCP_Port;

    @Value("${elasticsearch.cluster-name}")
    private String CLUSTER_NAME;


    @Bean
    public Client client() throws Exception {
        log.info(ES_Host);
        log.info(ES_TCP_Port.toString());
        log.info(CLUSTER_NAME);
        Settings settings = Settings.builder()
                .put("cluster.name", CLUSTER_NAME).build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(ES_Host), ES_TCP_Port));
        return client;
    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }




}
