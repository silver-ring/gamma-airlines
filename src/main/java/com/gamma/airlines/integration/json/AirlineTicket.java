/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration.json;


import lombok.Builder;
import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Class AirlineTicket.
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
public class AirlineTicket {

  /** amount. */
  private Integer amount;

  /** details. */
  private AirlineOffer details;

  /**
   * Instantiates a new airline ticket.
   */
  public AirlineTicket() {

  }

  /**
   * Instantiates a new airline ticket.
   *
   * @param amount amount
   * @param details details
   */
  public AirlineTicket(Integer amount, AirlineOffer details) {
    this.amount = amount;
    this.details = details;
  }

}
