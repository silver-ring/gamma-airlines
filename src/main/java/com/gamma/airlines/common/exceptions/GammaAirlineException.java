/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Class GammaAirlineException.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class GammaAirlineException extends RuntimeException {

  /** Constant serialVersionUID. */
  private static final long serialVersionUID = -4625643625487789840L;

  /**
   * Instantiates a new gamma airline exception.
   */
  public GammaAirlineException() {
    super("Unknown Failure");
  }

  /**
   * Instantiates a new gamma airline exception.
   *
   * @param message message
   */
  protected GammaAirlineException(String message) {
    super(message);
  }

}
