package me.toy.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
                .id("1001")
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
    }

    @Test
    public void findByAuthor() {
    }

    @Test
    public void findByTitle() {
    }
}