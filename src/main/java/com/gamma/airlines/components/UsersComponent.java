/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.components;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.Customer;

// TODO: Auto-generated Javadoc
/**
 * Interface UsersComponent.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public interface UsersComponent extends IService {

  /**
   * Gets logged in customer.
   *
   * @return logged in customer
   */
  Customer getLoggedInCustomer();

  /**
   * Gets logged in user role.
   *
   * @return logged in user role
   */
  String getLoggedInUserRole();

  /**
   * Hash raw password.
   *
   * @param rawPassword raw password
   * @return string
   */
  String hashRawPassword(String rawPassword);
}
