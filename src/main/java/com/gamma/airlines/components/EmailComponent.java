/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.components;

import org.springframework.web.servlet.ModelAndView;

import com.gamma.airlines.common.IComponent;
import com.gamma.airlines.common.domain.Customer;

// TODO: Auto-generated Javadoc
/**
 * Interface EmailComponent.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public interface EmailComponent extends IComponent {

  /**
   * Send email to customer.
   *
   * @param customer customer
   * @param modelAndView model and view
   */
  void sendEmailToCustomer(Customer customer, ModelAndView modelAndView);

}
