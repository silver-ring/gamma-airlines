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
 * Class AirlineTicketData.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

/**
 * Instantiates a new airline ticket data.
 */

/**
 * Instantiates a new airline ticket data.
 */

/**
 * Instantiates a new airline ticket data.
 */
@Data
public class AirlineTicketData {

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
   * @return airline ticket
   */
  public AirlineTicket mapToAirlineTicket() {
    AirlineRoute airlineRoute = AirlineRoute.builder().from(this.from).to(this.to).build();
    MonetaryAmount monetaryAmount =
        MonetaryAmount.builder().amount(this.price).currency(this.currency).build();
    AirlineOffer airlineOffer =
        AirlineOffer.builder().price(monetaryAmount).route(airlineRoute).build();
    return AirlineTicket.builder().amount(this.numberOfTickets).details(airlineOffer).build();
  }

}
