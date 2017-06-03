/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration.json;

import lombok.Builder;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class DepositWithdrawRequest.
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
public class DepositWithdrawRequest {

  /** account id. */
  private String accountId;

  /** monetary amount. */
  private MonetaryAmount monetaryAmount;

  /**
   * Instantiates a new deposit withdraw request.
   */
  public DepositWithdrawRequest() {

  }

  /**
   * Instantiates a new deposit withdraw request.
   *
   * @param accountId account id
   * @param monetaryAmount monetary amount
   */
  public DepositWithdrawRequest(String accountId, MonetaryAmount monetaryAmount) {
    this.accountId = accountId;
    this.monetaryAmount = monetaryAmount;
  }


}
