https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#repositories

# Working with Spring Data Repositories

The goal of the Spring Data repository abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores.



# Elasticsearch Clients

This chapter illustrates configuration and usage of supported Elasticsearch client implementations.

Spring data Elasticsearch operates upon an Elasticsearch client that is connected to a single Elasticsearch node or a cluster. Although the Elasticsearch Client can be used to work with the cluster, applications using Spring Data Elasticsearch normally use the higher level abstractions of [Elasticsearch Operations](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.operations) and [Elasticsearch Repositories](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.repositories).



## 13. High Level REST Client

The Java High Level REST Client now is <u>**the default client of Elasticsearch**</u>, it provides a straight forward replacement for the `TransportClient` as it accepts and returns the very same request/response objects and therefore depends on the Elasticsearch core project. **<u>Asynchronous calls are operated upon a client managed thread pool and require a callback to be notified when the request is done.</u>**

# Elasticsearch Object Mapping

Spring Data Elasticsearch allows to choose between two mapping implementations abstracted via the `EntityMapper` interface:

- [Jackson Object Mapping](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.mapping.jackson2)
- [Meta Model Object Mapping](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.mapping.meta-model)



# Elasticsearch Operations

Spring Data Elasticsearch uses two interfaces to define the operations that can be called against an Elasticsearch index. These are `ElasticsearchOperations` and `ReactiveElasticsearchOperations`. Whereas the first is used with the classic synchronous implementations, the second one uses reactive infrastructure.

The default implementations of the interfaces offer:

- Read/Write mapping support for domain types.
- A rich query and criteria api.
- Resource management and Exception translation.



Reactive Template를 사용하여, 2번 요청 가능

```java
template.save(new Person("Bruce Banner", 42))                    
  .doOnNext(System.out::println)
  .flatMap(person -> template.findById(person.id, Person.class)) 
  .doOnNext(System.out::println)
  .flatMap(person -> template.delete(person))                    
  .doOnNext(System.out::println)
  .flatMap(id -> template.count(Person.class))                   
  .doOnNext(System.out::println)
  .subscribe(); 
```

