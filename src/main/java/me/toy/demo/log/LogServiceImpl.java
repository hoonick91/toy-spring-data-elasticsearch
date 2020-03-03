package me.toy.demo.log;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LogServiceImpl {

    LogRepository logRepository;


    public Page<APICallLog> findByRequestorIdAndTransactionId(String requestorId, String transactionId, PageRequest pageRequest) {
        return logRepository.findByRequestorIdAndTransactionId(requestorId, transactionId, pageRequest);
    }

    public Iterable<APICallLog> findAll() {
        return logRepository.findAll();
    }
}
