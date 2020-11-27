package com.advantech.springsecurity.controller;

import com.advantech.springsecurity.jpa.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/v1/")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

}
