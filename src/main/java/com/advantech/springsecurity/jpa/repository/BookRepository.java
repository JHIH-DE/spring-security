package com.advantech.springsecurity.jpa.repository;

import com.advantech.springsecurity.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  @Override
  Optional<Book> findById(Integer integer);

  Optional<Book> findByName(String name);
}