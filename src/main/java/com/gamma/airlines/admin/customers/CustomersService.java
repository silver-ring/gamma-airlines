/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.Customer;

/**
 * Class CustomersService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class CustomersService implements IService {

  /** customer repository. */
  @Autowired
  private CustomersRepository customerRepository;


  /**
   * Find all customers.
   *
   * @return list
   */
  List<CustomerModel> findAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    return CustomerModel.mapFromCustomers(customers);
  }

}
