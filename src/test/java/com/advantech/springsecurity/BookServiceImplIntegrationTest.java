package com.advantech.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;

import com.advantech.springsecurity.exception.NoSuchResourceException;
import com.advantech.springsecurity.service.BookService;
import com.advantech.springsecurity.service.BookServiceImpl;
import com.advantech.springsecurity.jpa.entity.Book;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookServiceImplIntegrationTest {

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

  private Book book;

  @Before
  public void setUp() {
    book = new Book();
    book.setName("無瑕的程式碼－敏捷軟體開發技巧守則");
    book.setAuthor("Robert C. Martin");

    Optional<Book> bookOptional = Optional.of(book);

    Mockito.when(bookRepository.findByName(book.getName()))
        .thenReturn(bookOptional);
  }

  @Test
  public void validName_thenBookShouldBeFound() throws NoSuchResourceException {

    Book found = bookService.getBookByName(book.getName());

    assertThat(found.getName())
        .isEqualTo(book.getName());

  }
}
