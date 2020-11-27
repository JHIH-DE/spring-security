package com.advantech.springsecurity.jpa.entity;

import javax.persistence.Table;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Table(name="book")
public class Book {
  @Id
  @GeneratedValue
  private Integer bookid;
  private String name;
  private String author;
}