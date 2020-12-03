package com.advantech.springsecurity.service;

import com.advantech.springsecurity.exception.NoSuchResourceException;
import com.advantech.springsecurity.jpa.entity.Book;

import java.util.List;

public interface BookService {

  Book getBookById(Integer id) throws NoSuchResourceException;

  Book getBookByName(String name) throws NoSuchResourceException;

  List<Book> getAllBooks();

  Book addBook(Book book);
}
