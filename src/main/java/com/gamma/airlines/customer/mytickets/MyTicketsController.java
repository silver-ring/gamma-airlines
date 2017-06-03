/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.customer.mytickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

// TODO: Auto-generated Javadoc
/**
 * Class MyTicketsController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class MyTicketsController implements IController {

  /** my tickets service. */
  @Autowired
  private MyTicketsService myTicketsService;

  /**
   * View my tickets.
   *
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @GetMapping(URLS.CUSTOMER_MY_TICKETS)
  public String viewMyTickets(Model model) {

    final String TICKETS_ATT_NAME = "tickets";
    final String CUSTOMER_MY_TICKETS_VIEW = "customer/my_tickets";

    List<OrderModel> ticketRow = myTicketsService.getAllLoggedInCustomerTickets();

    model.addAttribute(TICKETS_ATT_NAME, ticketRow);
    return CUSTOMER_MY_TICKETS_VIEW;
  }


}
