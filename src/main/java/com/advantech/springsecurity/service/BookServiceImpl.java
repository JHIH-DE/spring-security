package com.advantech.springsecurity.service;

import com.advantech.springsecurity.jpa.entity.BookEntity;
import com.advantech.springsecurity.jpa.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BookService")
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;


  @Override
  public BookEntity getBookById(Integer id) throws Exception {
    Optional<BookEntity> bookOptional = bookRepository.findById(id);
    if (bookOptional.isPresent()) {
      return bookOptional.get();
    } else {
      throw new Exception("NoSuchResourceException");
    }
  }

  @Override
  public List<BookEntity> getBookByName(String name) {
    return bookRepository.findByName(name);
  }

  @Override
  public List<BookEntity> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public BookEntity addBook(BookEntity bookEntity) {
    return bookRepository.save(bookEntity);
  }
}
