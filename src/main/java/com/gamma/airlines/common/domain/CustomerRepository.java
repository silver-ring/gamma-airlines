/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

// TODO: Auto-generated Javadoc
/**
 * Interface CustomerRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public interface CustomerRepository extends UsersRepository<Customer> {

  /**
   * Find by username.
   *
   * @param username username
   * @return customer
   */
  Customer findByUsername(String username);

}
