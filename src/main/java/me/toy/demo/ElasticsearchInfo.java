package me.toy.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchInfo {

    public static String HOST;
    public static int PORT;

    @Value("${elasticsearch.host}")
    public static void setHOST(String host) {
        HOST = host;
    }

    @Value("${elasticsearch.port}")
    public static void setPORT(int port) {
        PORT = port;
    }
}
