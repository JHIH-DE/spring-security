package com.advantech.springsecurity.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "book")
public class Book {
  /**
   * IDENTITY：主鍵由數據庫自動生成（主要是自動增長型）
   * AUTO：主鍵由程序控制。
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bookid", unique = true, nullable = false)
  private Integer bookid;
  @Column(name = "name")
  private String name;
  @Column(name = "author")
  private String author;
}