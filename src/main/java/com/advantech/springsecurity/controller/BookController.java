package com.advantech.springsecurity.controller;

import com.advantech.springsecurity.service.BookService;
import com.advantech.springsecurity.dto.BookDTO;
import com.advantech.springsecurity.jpa.entity.Book;
import com.advantech.springsecurity.mapper.BookMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "Book")
@RequestMapping("/rest/v1")
public class BookController {

  @Autowired
  private BookService bookService;
  @Autowired
  private BookMapper bookMapper;


  @ApiOperation(value = "取得書本", notes = "列出所有書本")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<BookDTO> getAllBooks() {
    return bookMapper.toDTO(bookService.getAllBooks());
  }

  @ApiOperation(value = "新增書本", notes = "新增書本的內容")
  @ApiResponses(value = {@ApiResponse(code = 201, message = "存檔成功")})
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public BookDTO create(
      @ApiParam(required = true, value = "書本內容") @RequestBody BookDTO bookDto) {
    Book book = bookMapper.toEntity(bookDto);
    book = bookService.addBook(book);
    bookDto.setId(book.getBookid());
    return bookDto;
  }

  @ApiOperation(value = "取得書本內容", notes = "取得書本內容")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "書本資訊")})
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/book/{bookid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public BookDTO get(
      @ApiParam(required = true, name = "bookid", value = "書本ID") @PathVariable Integer bookid)
      throws Exception {
    Book book = bookService.getBookById(bookid);
    return bookMapper.toDTO(book);
  }
}
