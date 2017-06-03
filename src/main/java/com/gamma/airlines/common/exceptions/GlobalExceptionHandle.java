/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * Class GlobalExceptionHandle.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandle {

  /** Constant ERROR_VIEW. */
  private static final String ERROR_VIEW = "/error";

  /** Constant ERROR_MESSAGE_ATT_NAME. */
  private static final String ERROR_MESSAGE_ATT_NAME = "errorMessage";

  /**
   * Handle gamma airlines exceptions.
   *
   * @param model model
   * @param ex ex
   * @return string
   */
  @ExceptionHandler(GammaAirlineException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public String handleGammaAirlinesExceptions(Model model, Exception ex) {
    model.addAttribute(ERROR_MESSAGE_ATT_NAME, ex.getMessage());
    return ERROR_VIEW;
  }

  /**
   * Handl un expected exception.
   *
   * @param model model
   * @param ex ex
   * @return string
   */
  @ExceptionHandler(Throwable.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public String handlUnExpectedException(Model model, Throwable ex) {
    GammaAirlineException gammaAirlineException = new GammaAirlineException();
    model.addAttribute(ERROR_MESSAGE_ATT_NAME, gammaAirlineException.getMessage());
    Logger.getRootLogger().error(ex.getMessage(), ex);
    return ERROR_VIEW;
  }

}
