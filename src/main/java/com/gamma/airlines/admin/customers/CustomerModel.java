/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.customers;

import java.util.List;
import java.util.stream.Collectors;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.Customer;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * Class CustomerModel.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Data
@Builder
class CustomerModel implements IModel {

  /** email. */
  @NonNull
  private String email;

  /** full name. */
  @NonNull
  private String fullName;

  /** paypallets account id. */
  @NonNull
  private String paypalletsAccountId;

  /**
   * Map from customers.
   *
   * @param customers customers
   * @return list
   */
  static List<CustomerModel> mapFromCustomers(List<Customer> customers) {
    return customers.stream().map(CustomerModel::mapFromCustomer).collect(Collectors.toList());
  }

  /**
   * Map from customer.
   *
   * @param customer customer
   * @return customer model
   */
  private static CustomerModel mapFromCustomer(Customer customer) {
    return CustomerModel.builder().email(customer.getEmail()).fullName(customer.getFullName())
        .paypalletsAccountId(customer.getPaypalletsAccountId()).build();
  }

}

