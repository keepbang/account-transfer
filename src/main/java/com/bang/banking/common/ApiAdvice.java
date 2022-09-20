package com.bang.banking.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiAdvice {

  @ExceptionHandler({IllegalArgumentException.class})
  protected ResponseEntity<ErrorResponse> handleValidException(IllegalArgumentException e) {
    return ResponseEntity.badRequest()
        .body(new ErrorResponse("ErrorCode-01", e.getMessage()));
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<ErrorResponse> validException(MethodArgumentNotValidException e) {

    String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();

    return ResponseEntity.badRequest()
        .body(new ErrorResponse("ErrorCode-02", message));
  }

}
