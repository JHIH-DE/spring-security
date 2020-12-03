package com.advantech.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;

import com.advantech.springsecurity.config.DaoConfig;
import com.advantech.springsecurity.jpa.entity.Book;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = DaoConfig.class)
public class BookRepositoryIntegrationTest {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private TestEntityManager entityManager;

  private Book book;

  @Before
  public void setUp() {
    book = new Book();
    book.setName("無瑕的程式碼－敏捷軟體開發技巧守則");
    book.setAuthor("Robert C. Martin");
    bookRepository.save(book);
  }

  @Test
  public void findByName_thenReturnBook() {
    Optional<Book> found = bookRepository.findById(book.getBookid());
    assertThat(found.get().getName())
        .isEqualTo(book.getName());

    Optional<Book> found2 = bookRepository.findByName(book.getName());
    assertThat(found2.get().getName())
        .isEqualTo(book.getName());

  }
}
