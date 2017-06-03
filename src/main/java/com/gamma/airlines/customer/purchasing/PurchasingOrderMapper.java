/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.integration.json.AirlineRoute;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.MonetaryAmount;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingOrderMapper.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
class PurchasingOrderMapper {



  /**
   * Map from airline ticket.
   *
   * @param airlineTicket airline ticket
   * @param customer customer
   * @return purchasing order
   */
  static PurchasingOrder mapFromAirlineTicket(AirlineTicket airlineTicket, Customer customer) {
    AirlineRoute ticketRoute = airlineTicket.getDetails().getRoute();
    MonetaryAmount ticketPrice = airlineTicket.getDetails().getPrice();
    Integer numberOfTickets = airlineTicket.getAmount();
    Double totalAmount = ticketPrice.getAmount() * numberOfTickets;



    return PurchasingOrder.builder().customer(customer).fromCity(ticketRoute.getFrom())
        .toCity(ticketRoute.getTo()).ticketPrice(ticketPrice.getAmount())
        .currency(ticketPrice.getCurrency()).numberOfTickets(numberOfTickets)
        .totalAmount(totalAmount).build();
  }


}
