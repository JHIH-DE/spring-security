package com.advantech.springsecurity.jpa.repository;

import com.advantech.springsecurity.jpa.entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

  @Query(value = "SELECT b FROM BookEntity b WHERE b.author = :name", nativeQuery = true)
  List<BookEntity> findByName(@Param("name") String name);
}