/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.CustomerRepository;

// TODO: Auto-generated Javadoc
/**
 * Interface RegistrationCustomerRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface RegistrationCustomerRepository extends CustomerRepository {

  /**
   * Exists by username.
   *
   * @param username username
   * @return true, if successful
   */
  boolean existsByUsername(String username);

  /**
   * Exists by email.
   *
   * @param email email
   * @return true, if successful
   */
  boolean existsByEmail(String email);

  /**
   * Save.
   *
   * @param customer customer
   * @return customer
   */
  Customer save(Customer customer);

}
