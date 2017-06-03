/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Class OfferNotFoundException.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class OfferNotFoundException extends GammaAirlineException {

  /** Constant serialVersionUID. */
  private static final long serialVersionUID = -1159219623586666832L;

  /**
   * Instantiates a new offer not found exception.
   */
  public OfferNotFoundException() {
    super("Offer can not be found");
  }

}
