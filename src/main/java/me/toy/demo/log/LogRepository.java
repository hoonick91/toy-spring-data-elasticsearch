package me.toy.demo.log;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public interface LogRepository extends ElasticsearchRepository<APICallLog, String> {
    Page<APICallLog> findByRequestorIdAndTransactionId(String requestorId, String transactionId, Pageable pageable);

    @Override
    Iterable<APICallLog> findAll();
}
