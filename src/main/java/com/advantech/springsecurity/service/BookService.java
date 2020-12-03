package com.advantech.springsecurity.service;

import com.advantech.springsecurity.jpa.entity.Book;

import java.util.List;

public interface BookService {

  Book getBookById(Integer id) throws Exception;

  Book getBookByName(String name) throws Exception;

  List<Book> getAllBooks();

  Book addBook(Book book);
}
