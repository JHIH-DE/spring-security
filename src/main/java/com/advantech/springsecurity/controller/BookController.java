package com.advantech.springsecurity.controller;

import com.advantech.springsecurity.jpa.entity.Book;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/v1/")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/admin/books", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Book> getBooks() {
    log.info("enter getBooks controller.");
    return bookRepository.findAll();
  }
}
