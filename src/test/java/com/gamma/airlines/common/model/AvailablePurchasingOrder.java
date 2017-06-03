/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.model;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.enums.Currency;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class AvailablePurchasingOrder.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

/**
 * Instantiates a new available purchasing order.
 */

/**
 * Instantiates a new available purchasing order.
 */

/**
 * Instantiates a new available purchasing order.
 */
@Data
public class AvailablePurchasingOrder {

  /** id. */
  private Long id;

  /** number of tickets. */
  private Integer numberOfTickets;

  /** from city. */
  private String fromCity;

  /** to city. */
  private String toCity;

  /** ticket price. */
  private Double ticketPrice;

  /** currency. */
  private Currency currency;

  /** total amount. */
  private Double totalAmount;

  /** email. */
  private String email;

  /** full name. */
  private String fullName;


  /**
   * Map to purchasing order.
   *
   * @return purchasing order
   */
  public PurchasingOrder mapToPurchasingOrder() {
    Customer customer = Customer.builder().email(this.email).fullName(this.fullName).build();
    return PurchasingOrder.builder().customer(customer).id(this.id)
        .numberOfTickets(this.numberOfTickets).fromCity(this.fromCity).toCity(this.toCity)
        .ticketPrice(this.ticketPrice).currency(this.currency).totalAmount(this.totalAmount)
        .build();
  }

}
