/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.model;

import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.integration.json.AirlineOffer;
import com.gamma.airlines.integration.json.AirlineRoute;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.MonetaryAmount;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class CreatedOffer.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

/**
 * Instantiates a new created offer.
 */

/**
 * Instantiates a new created offer.
 */

/**
 * Instantiates a new created offer.
 */
@Data
public class CreatedOffer {

  /** number of tickets. */
  private Integer numberOfTickets;

  /** from. */
  private String from;

  /** to. */
  private String to;

  /** price. */
  private Double price;

  /** currency. */
  private Currency currency;


  /**
   * Map to airline ticket.
   *
   * @param createdOffer created offer
   * @return airline ticket
   */
  public static AirlineTicket mapToAirlineTicket(CreatedOffer createdOffer) {
    MonetaryAmount price = MonetaryAmount.builder().amount(createdOffer.getPrice())
        .currency(createdOffer.getCurrency()).build();
    AirlineRoute route =
        AirlineRoute.builder().from(createdOffer.getFrom()).to(createdOffer.getTo()).build();
    AirlineOffer airlineOffer = AirlineOffer.builder().price(price).route(route).build();
    return AirlineTicket.builder().amount(createdOffer.getNumberOfTickets()).details(airlineOffer)
        .build();
  }
}
