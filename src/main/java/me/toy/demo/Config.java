package me.toy.demo;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class Config {

    Environment environment;

    public Config(Environment environment) {
        this.environment = environment;
    }

    @Primary
    @Bean
    RestHighLevelClient client() {

        String host = environment.getProperty("elasticsearch.host");
        String port = environment.getProperty("elasticsearch.port");

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

}
