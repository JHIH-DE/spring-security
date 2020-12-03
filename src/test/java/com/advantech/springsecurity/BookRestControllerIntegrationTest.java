package com.advantech.springsecurity;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.advantech.springsecurity.service.BookService;
import com.advantech.springsecurity.jpa.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class BookRestControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BookService bookService;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private Book book;

  @Before
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    book = new Book();
    book.setBookid(1);
    book.setName("無瑕的程式碼－敏捷軟體開發技巧守則");
    book.setAuthor("Robert C. Martin");
  }

  @Test
  public void givenBook_whenGetBook_thenReturnJsonArray() throws Exception {

    //Mocking
    when(this.bookService.getBookById(book.getBookid())).thenReturn(book);

    ResultActions resultActions = mvc.perform(
        get("/rest/v1/book/" + book.getBookid()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("id", is(1)));
  }
}
