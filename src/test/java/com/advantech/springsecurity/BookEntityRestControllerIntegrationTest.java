package com.advantech.springsecurity;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.advantech.springsecurity.service.BookService;
import com.advantech.springsecurity.jpa.entity.BookEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class BookEntityRestControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BookService bookService;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private BookEntity bookEntity;

  @Before
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    bookEntity = new BookEntity();
    bookEntity.setBookid(1);
    bookEntity.setName("被討厭的勇氣：自我啟發之父「阿德勒」的教導");
    bookEntity.setAuthor("岸見一郎");
  }

  @Test
  public void givenBook_whenGetBook_thenReturnJsonArray() throws Exception {

    //Mocking
    when(this.bookService.getBookById(1)).thenReturn(bookEntity);

    ResultActions resultActions = mvc.perform(
        get("/rest/v1/book/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("id", is(1)));
  }
}
