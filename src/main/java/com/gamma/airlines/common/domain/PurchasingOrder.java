/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.gamma.airlines.common.IBaseEntity;
import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingOrder.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Entity
@Table(name = "AirlineTicketOrder")

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
public class PurchasingOrder implements IBaseEntity {

  /** id. */
  @Id
  @GenericGenerator(name = "AirlineTicketOrder_PK_SEQ", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
      @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled-lo"),
      @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
      @org.hibernate.annotations.Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "AirlineTicketOrder_PK_SEQ")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AirlineTicketOrder_PK_SEQ")
  private Long id;

  /** customer. */
  @ManyToOne
  private Customer customer;

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

  /**
   * Instantiates a new purchasing order.
   */
  public PurchasingOrder() {

  }

  /**
   * Instantiates a new purchasing order.
   *
   * @param id id
   * @param customer customer
   * @param numberOfTickets number of tickets
   * @param fromCity from city
   * @param toCity to city
   * @param ticketPrice ticket price
   * @param currency currency
   * @param totalAmount total amount
   */
  public PurchasingOrder(Long id, Customer customer, Integer numberOfTickets, String fromCity,
      String toCity, Double ticketPrice, Currency currency, Double totalAmount) {
    this.id = id;
    this.customer = customer;
    this.numberOfTickets = numberOfTickets;
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.ticketPrice = ticketPrice;
    this.currency = currency;
    this.totalAmount = totalAmount;
  }



}
