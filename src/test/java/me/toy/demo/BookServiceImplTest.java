package me.toy.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;


    BookServiceImpl bookService;

    @Autowired
    @Qualifier("bookRepository")
    BookRepository bookRepository;

    @Before
    public void setup() {
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void save() {
        Book book = Book.builder()
                .id("1002")
                .title("elsaticsesa")
                .author("jhoon")
                .releaseDate("23-FEB-2017")
                .build();

        Book testBook = bookService.save(book);

        assertNotNull(testBook.getId());
        assertEquals(testBook.getTitle(), book.getTitle());
    }

    @Test
    public void delete() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
        Iterable<Book> books = bookService.findAll();
        books.iterator().forEachRemaining(iter -> log.info(iter.toString()));
    }

    @Test
    public void findByAuthor() {
        Page<Book> books = bookService.findByAuthor("jhoon", PageRequest.of(0, 10));
        List<Book> bookList = books.get().collect(Collectors.toList());
        log.info(bookList.toString());
    }

    @Test
    public void findByTitle() {
    }
}