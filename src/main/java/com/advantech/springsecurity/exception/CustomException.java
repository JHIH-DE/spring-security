package com.advantech.springsecurity.exception;

public class CustomException extends Exception {

  private static final long serialVersionUID = 1L;

  private int statusCode = -1;

  public CustomException() {
    super();
  }

  public CustomException(String msg) {
    super(msg);
  }

  public CustomException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public CustomException(Throwable cause) {
    super(cause);
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }
}
