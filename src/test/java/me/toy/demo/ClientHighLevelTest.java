package me.toy.demo;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientHighLevelTest {

    @Autowired
    ClientHighLevel clientHighLevel;

    @Test
    public void clientTest() {

        IndexResponse indexResponse = clientHighLevel.response();
        log.info(indexResponse.toString());


    }

}