/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.model;

import java.util.List;
import java.util.stream.Collectors;

import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.integration.json.AirlineOffer;
import com.gamma.airlines.integration.json.AirlineRoute;
import com.gamma.airlines.integration.json.MonetaryAmount;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class AvailableOffer.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

/**
 * Instantiates a new available offer.
 */

/**
 * Instantiates a new available offer.
 */

/**
 * Instantiates a new available offer.
 */
@Data
public class AvailableOffer {

  /** from. */
  private String from;

  /** to. */
  private String to;

  /** amount. */
  private Double amount;

  /** currency. */
  private Currency currency;


  /**
   * Map to airline offers.
   *
   * @param availableOffers available offers
   * @return list
   */
  public static List<AirlineOffer> mapToAirlineOffers(List<AvailableOffer> availableOffers) {
    return availableOffers.stream().map((availableOffer) -> {
      MonetaryAmount price = MonetaryAmount.builder().amount(availableOffer.getAmount())
          .currency(availableOffer.getCurrency()).build();
      AirlineRoute route =
          AirlineRoute.builder().from(availableOffer.getFrom()).to(availableOffer.getTo()).build();
      return AirlineOffer.builder().route(route).price(price).build();
    }).collect(Collectors.toList());
  }
}
