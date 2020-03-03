package me.toy.demo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
@Document(indexName = "spring-data-test", type = "doc")
public class Book {
    @Id
    String id;
    String title;
    String author;
    String releaseDate;
}
