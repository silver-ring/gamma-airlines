/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.integration.json.AirlineOffer;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


// TODO: Auto-generated Javadoc
/**
 * Class PurchasingDetailsModel.
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
class PurchasingDetailsModel implements IModel {

  /** full name. */
  @NonNull
  private String fullName;

  /** from. */
  @NonNull
  private String from;

  /** to. */
  @NonNull
  private String to;

  /** ticket price. */
  @NonNull
  private Double ticketPrice;

  /** currency. */
  @NonNull
  private Currency currency;

  /** paypallets account id. */
  @NonNull
  private String paypalletsAccountId;


  /**
   * Map from airline offer.
   *
   * @param airlineOffer airline offer
   * @param customer customer
   * @return purchasing details model
   */
  static PurchasingDetailsModel mapFromAirlineOffer(AirlineOffer airlineOffer, Customer customer) {
    return PurchasingDetailsModel.builder().fullName(customer.getFullName())
        .from(airlineOffer.getRoute().getFrom()).to(airlineOffer.getRoute().getTo())
        .ticketPrice(airlineOffer.getPrice().getAmount())
        .currency(airlineOffer.getPrice().getCurrency())
        .paypalletsAccountId(customer.getPaypalletsAccountId()).build();
  }
}
