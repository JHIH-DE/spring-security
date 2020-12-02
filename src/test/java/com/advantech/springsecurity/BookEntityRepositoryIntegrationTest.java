package com.advantech.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;

import com.advantech.springsecurity.config.DaoConfig;
import com.advantech.springsecurity.jpa.entity.BookEntity;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = DaoConfig.class)
public class BookEntityRepositoryIntegrationTest {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private TestEntityManager entityManager;

  private BookEntity book;

  @Before
  public void init(){
    // given
    book = new BookEntity();
    book.setBookid(13);
    book.setName("被討厭的勇氣：自我啟發之父「阿德勒」的教導");
    book.setAuthor("岸見一郎");
    bookRepository.save(book);
  }

  @Test
  public void findByName_thenReturnBook() {
      Optional<BookEntity> found = bookRepository.findById(1);
      // then
      assertThat(found.get().getName())
          .isEqualTo(book.getName());

      System.out.println("ID: " + found.get().getBookid());
      System.out.println("Name: " + found.get().getName());

      //List<BookEntity> test = bookRepository.findByName("岸見一郎");

  }
}
