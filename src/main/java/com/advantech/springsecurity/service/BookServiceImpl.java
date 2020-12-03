package com.advantech.springsecurity.service;

import com.advantech.springsecurity.exception.NoSuchResourceException;
import com.advantech.springsecurity.jpa.entity.Book;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BookService")
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;


  @Override
  public Book getBookById(Integer id) throws NoSuchResourceException {
    Optional<Book> bookOptional = bookRepository.findById(id);
    if (bookOptional.isPresent()) {
      return bookOptional.get();
    } else {
      throw new NoSuchResourceException();
    }
  }

  @Override
  public Book getBookByName(String name) throws NoSuchResourceException {
    Optional<Book> bookOptional = bookRepository.findByName(name);
    if (bookOptional.isPresent()) {
      return bookOptional.get();
    } else {
      throw new NoSuchResourceException();
    }
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book addBook(Book book) {
    return bookRepository.save(book);
  }
}
