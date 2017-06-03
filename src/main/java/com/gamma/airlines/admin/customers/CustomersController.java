/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

/**
 * Class CustomersController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class CustomersController implements IController {

  /** customer service. */
  @Autowired
  private CustomersService customerService;


  /**
   * Show all customers.
   *
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_ADMIN)
  @GetMapping(URLS.ADMIN_CUSTOMERS)
  public String showAllCustomers(final Model model) {

    final String customersAttName = "customers";
    final String adminCustoemrsView = "admin/customers";

    final List<CustomerModel> customerRows = customerService.findAllCustomers();
    model.addAttribute(customersAttName, customerRows);

    return adminCustoemrsView;
  }

}
