/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Class Customer.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Entity

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#toString()
 */
@Data

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#hashCode()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#hashCode()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#hashCode()
 */

/*
 * (non-Javadoc)
 * 
 * @see com.gamma.airlines.common.domain.Users#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
public class Customer extends Users {

  /** email. */
  @Column(nullable = false, unique = true)
  protected String email;

  /** paypallets account id. */
  @Column(nullable = false, unique = true)
  protected String paypalletsAccountId;

  /** full name. */
  @Column(nullable = false)
  protected String fullName;

  /** airline ticket orders. */
  @OneToMany(mappedBy = "customer")
  protected List<PurchasingOrder> airlineTicketOrders;

  /**
   * Instantiates a new customer.
   */
  public Customer() {}

  /**
   * Instantiates a new customer.
   *
   * @param username username
   * @param password password
   * @param email email
   * @param paypalletsAccountId paypallets account id
   * @param fullName full name
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
  @Builder
  public Customer(String username, String password, String email, String paypalletsAccountId,
      String fullName) {
    super(username, password, true);
    this.email = email;
    this.paypalletsAccountId = paypalletsAccountId;
    this.fullName = fullName;
  }


}
