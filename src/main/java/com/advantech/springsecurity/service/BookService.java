package com.advantech.springsecurity.service;

import com.advantech.springsecurity.jpa.entity.BookEntity;
import java.util.List;

public interface BookService {
  BookEntity getBookById(Integer id) throws Exception;

  List<BookEntity>  getBookByName(String name);

  List<BookEntity> getAllBooks();

  BookEntity addBook(BookEntity bookEntity);
}
