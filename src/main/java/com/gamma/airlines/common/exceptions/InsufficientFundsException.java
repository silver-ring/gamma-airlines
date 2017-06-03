/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Class InsufficientFundsException.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class InsufficientFundsException extends GammaAirlineException {

  /** Constant serialVersionUID. */
  private static final long serialVersionUID = -7337280933294398492L;

  /**
   * Instantiates a new insufficient funds exception.
   */
  public InsufficientFundsException() {
    super("You do not have enough funds in your account");
  }

}
