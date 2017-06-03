/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration.json;

import lombok.Builder;
import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Class AirlineOffer.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data
public class AirlineOffer {

  /** route. */
  AirlineRoute route;

  /** price. */
  MonetaryAmount price;


  /**
   * Instantiates a new airline offer.
   */
  public AirlineOffer() {

  }

  /**
   * Instantiates a new airline offer.
   *
   * @param route route
   * @param price price
   */
  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Builder
  public AirlineOffer(AirlineRoute route, MonetaryAmount price) {
    super();
    this.route = route;
    this.price = price;       
  }



}
