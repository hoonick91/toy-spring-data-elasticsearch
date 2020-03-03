package me.toy.demo.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.elasticsearch.common.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Document(indexName = "api-call-log*", type = "doc")
public class APICallLog {
    @Id
    String _id;
    String module_name;
    String requestorSeq;
    String errorCode;
    String errorMessage;
    String requestClientId;
    String requestIp;
    String transactionId;
    String requestorId;
    String requestMethod;
    String requestUri;
    String responseBody;
    String requestBody;
    Map<String, Object> requestHeader;
    Map<String, Object> responseHeader;
    Map<String, Object> requestParameters;
    String instance_id;
    Long httpStatusCode;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss.SSS")
    Date endTime;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss.SSS")
    Date startTime;
}
