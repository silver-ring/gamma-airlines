/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration.json;

import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Class ExchangeCurrenciesRequest.
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
public class ExchangeCurrenciesRequest {

  /** monetary amount. */
  private MonetaryAmount monetaryAmount;

  /** target currency. */
  private Currency targetCurrency;

  /**
   * Instantiates a new exchange currencies request.
   */
  public ExchangeCurrenciesRequest() {

  }

  /**
   * Instantiates a new exchange currencies request.
   *
   * @param monetaryAmount monetary amount
   * @param targetCurrency target currency
   */
  public ExchangeCurrenciesRequest(MonetaryAmount monetaryAmount, Currency targetCurrency) {
    this.monetaryAmount = monetaryAmount;
    this.targetCurrency = targetCurrency;
  }


}
