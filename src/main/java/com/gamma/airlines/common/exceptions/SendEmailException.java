/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Class SendEmailException.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class SendEmailException extends GammaAirlineException {


  /** Constant serialVersionUID. */
  private static final long serialVersionUID = -1133583246441145616L;

  /**
   * Instantiates a new send email exception.
   */
  public SendEmailException() {
    super(
        "Fail to send email due to messaging error, please make sure your email details are correct then try agian.");
  }

}
