package me.toy.demo.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogServiceImplTest {

    @Autowired
    @Qualifier("logRepository")
    LogRepository logRepository;

    @Autowired
    ObjectMapper objectMapper;


    LogServiceImpl logService;

    @Before
    public void setup() {
        logService = new LogServiceImpl(logRepository);
    }

    @Test
    public void findByRequestorIdAndTransactionId() {

        Page<APICallLog> logs = logService.findByRequestorIdAndTransactionId("makers09", "1583201387244-31278139", PageRequest.of(0, 10));
        log.info(logs.get().collect(Collectors.toList()).toString());

    }

    @Test
    public void findAllTest() throws Exception{
        Iterable<APICallLog> logs = logService.findAll();
        log.info(objectMapper.writeValueAsString(logs.iterator().next()));
    }
}