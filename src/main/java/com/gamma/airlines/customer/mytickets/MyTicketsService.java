/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.mytickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.components.UsersComponent;

// TODO: Auto-generated Javadoc
/**
 * Class MyTicketsService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class MyTicketsService implements IService {


  /** users component. */
  @Autowired
  private UsersComponent usersComponent;

  /**
   * Gets all logged in customer tickets.
   *
   * @return all logged in customer tickets
   */
  List<OrderModel> getAllLoggedInCustomerTickets() {
    final List<PurchasingOrder> purchasingOrders = getLoggedInCustomerAirlineTicketOrders();
    return OrderModel.mapFromPurchasingOrders(purchasingOrders);
  }

  /**
   * Gets logged in customer airline ticket orders.
   *
   * @return logged in customer airline ticket orders
   */
  private List<PurchasingOrder> getLoggedInCustomerAirlineTicketOrders() {
    final Customer loggedInCustomer = usersComponent.getLoggedInCustomer();
    return loggedInCustomer.getAirlineTicketOrders();
  }



}
