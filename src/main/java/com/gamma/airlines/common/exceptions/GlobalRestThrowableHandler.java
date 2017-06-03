/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// TODO: Auto-generated Javadoc
/**
 * Class GlobalRestThrowableHandler.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalRestThrowableHandler {

  /**
   * Handl offer not found error.
   *
   * @param ex ex
   * @return response entity
   */
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<?> handlOfferNotFoundError(Exception ex) {
    return ResponseEntity.badRequest().build();
  }

}
