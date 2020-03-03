package me.toy.demo.log;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LogController {

    LogRepository logRepository;

    @GetMapping("/log")
    public ResponseEntity retrieveLogs() {
        LogServiceImpl logService = new LogServiceImpl(logRepository);
        Page<APICallLog> e2ELogs = logService.findByRequestorIdAndTransactionId("makers09", "1583201387244-31278139", PageRequest.of(0, 10));
        return ResponseEntity.ok(e2ELogs);
    }
}
