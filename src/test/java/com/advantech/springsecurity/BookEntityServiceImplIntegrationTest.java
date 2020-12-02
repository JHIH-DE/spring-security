package com.advantech.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;

import com.advantech.springsecurity.service.BookService;
import com.advantech.springsecurity.service.BookServiceImpl;
import com.advantech.springsecurity.jpa.entity.BookEntity;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookEntityServiceImplIntegrationTest {

  @TestConfiguration
  static class EmployeeServiceImplTestContextConfiguration {

    @Bean
    public BookService bookService() {
      return new BookServiceImpl();
    }
  }

  @Autowired
  private BookService bookService;

  @MockBean
  private BookRepository bookRepository;

  @Before
  public void setUp() {
    BookEntity bookEntity = new BookEntity();
    bookEntity.setName("被討厭的勇氣：自我啟發之父「阿德勒」的教導");
    bookEntity.setAuthor("岸見一郎");

    List<BookEntity> bookEntities = Arrays.asList(bookEntity);

    Mockito.when(bookRepository.findByName(bookEntity.getName()))
        .thenReturn(bookEntities);
  }

  @Test
  public void validName_thenBookShouldBeFound() {
    String name = "被討厭的勇氣：自我啟發之父「阿德勒」的教導";
    List<BookEntity> found = bookService.getBookByName(name);

    assertThat(found.get(0).getName())
        .isEqualTo(name);
  }
}
