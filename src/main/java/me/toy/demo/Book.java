package me.toy.demo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
@Document(indexName = "spring-data-test2", type = "doc")
public class Book {
    @Id
    String id;
    String title;
    String author;
    String releaseDate;
}
