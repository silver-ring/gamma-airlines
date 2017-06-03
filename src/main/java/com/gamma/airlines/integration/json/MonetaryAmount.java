/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.integration.json;

import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Class MonetaryAmount.
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
public class MonetaryAmount {

  /** amount. */
  private Double amount;

  /** currency. */
  private Currency currency;

  /**
   * Instantiates a new monetary amount.
   */
  public MonetaryAmount() {

  }

  /**
   * Instantiates a new monetary amount.
   *
   * @param amount amount
   * @param currency currency
   */
  public MonetaryAmount(Double amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }


}
