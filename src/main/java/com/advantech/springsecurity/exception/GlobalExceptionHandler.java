package com.advantech.springsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.UnexpectedException;

/**
 * @RestController註解本身使用@ControllerAdvicer和@ResponseBody註解。
 * 使用了@RestControllerAdvice註解的類會被選定一個ControllerAdvicer。
 * 而該類中所有使用@ExceptionHandler註解的方法都替換使用了的@ResponseBody註解。
 */
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {CustomException.class})
  public ResponseEntity<?> customException(Exception ex) {
    CustomException exception = (CustomException) ex;
    ApiErrorModel apiErrorModel = new ApiErrorModel(exception.getStatusCode(),
        exception.getClass().getSimpleName(), exception.getMessage());
    return new ResponseEntity(apiErrorModel, HttpStatus.valueOf(exception.getStatusCode()));
  }

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity unexpectedException(Exception ex) {
    ApiErrorModel apiErrorModel = new ApiErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),
        UnexpectedException.class.getSimpleName(), ex.getMessage());
    return new ResponseEntity(apiErrorModel, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}