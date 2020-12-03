package com.advantech.springsecurity.exception;

public class ApiErrorModel {

  public Integer statusCode;
  public String type;
  public String msg;


  public ApiErrorModel(Integer statusCode, String type, String msg) {
    this.statusCode = statusCode;
    this.type = type;
    this.msg = msg;
  }

}