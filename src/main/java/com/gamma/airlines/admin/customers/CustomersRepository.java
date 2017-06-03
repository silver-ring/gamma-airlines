/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.customers;

import java.util.List;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.CustomerRepository;


/**
 * Interface CustomersRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
interface CustomersRepository extends CustomerRepository {

  /**
   * Find all.
   *
   * @return list
   */
  List<Customer> findAll();

}
