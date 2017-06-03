/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.CustomerRepository;

// TODO: Auto-generated Javadoc
/**
 * Class UsersComponentImpl.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Component
class UsersComponentImpl implements UsersComponent {

  /** customer repository. */
  @Autowired
  private CustomerRepository customerRepository;

  /*
   * (non-Javadoc)
   * 
   * @see com.gamma.airlines.components.UsersComponent#getLoggedInCustomer()
   */
  @Override
  public Customer getLoggedInCustomer() {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    return customerRepository.findByUsername(username);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.gamma.airlines.components.UsersComponent#getLoggedInUserRole()
   */
  @Override
  public String getLoggedInUserRole() {
    return SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next()
        .getAuthority();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.gamma.airlines.components.UsersComponent#hashRawPassword(java.lang.String)
   */
  @Override
  public String hashRawPassword(String rawPassword) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return passwordEncoder.encode(rawPassword);
  }

}
