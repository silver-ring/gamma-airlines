/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.model;

import com.gamma.airlines.integration.json.AirlineRoute;
import com.gamma.airlines.integration.json.BuyTicketsRequest;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class BuyTicketsData.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

/**
 * Instantiates a new buy tickets data.
 */

/**
 * Instantiates a new buy tickets data.
 */

/**
 * Instantiates a new buy tickets data.
 */
@Data
public class BuyTicketsData {

  /** account id. */
  private String accountId;

  /** number of tickets. */
  private Integer numberOfTickets;

  /** from. */
  private String from;

  /** to. */
  private String to;

  /**
   * Map to buy tickets request.
   *
   * @return buy tickets request
   */
  public BuyTicketsRequest mapToBuyTicketsRequest() {
    AirlineRoute airlineRoute = AirlineRoute.builder().from(this.from).to(this.to).build();
    return BuyTicketsRequest.builder().accountId(this.accountId).amount(this.numberOfTickets)
        .route(airlineRoute).build();
  }

}
