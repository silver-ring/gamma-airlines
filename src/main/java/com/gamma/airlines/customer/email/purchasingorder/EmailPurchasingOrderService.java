/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.email.purchasingorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.components.EmailComponent;
import com.gamma.airlines.components.UsersComponent;

// TODO: Auto-generated Javadoc
/**
 * Class EmailPurchasingOrderService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class EmailPurchasingOrderService {

  /** email component. */
  @Autowired
  private EmailComponent emailComponent;

  /** customer component. */
  @Autowired
  private UsersComponent customerComponent;

  /** email purchasing order repository. */
  @Autowired
  private EmailPurchasingOrderRepository emailPurchasingOrderRepository;

  /**
   * Find purchasing order.
   *
   * @param emailPurchasingOrderRequest email purchasing order request
   * @return purchasing order email model
   */
  PurchasingOrderEmailModel findPurchasingOrder(
      EmailPurchasingOrderRequest emailPurchasingOrderRequest) {

    PurchasingOrder purchasingOrder =
        emailPurchasingOrderRepository.findById(emailPurchasingOrderRequest.getOrderId());

    return PurchasingOrderEmailModel.mapFromPurchasingOrder(purchasingOrder);
  }


  /**
   * Send purchasing email.
   *
   * @param modelAndView model and view
   */
  void sendPurchasingEmail(ModelAndView modelAndView) {
    Customer loggedIncustomer = getLoggedInCustomer();
    emailComponent.sendEmailToCustomer(loggedIncustomer, modelAndView);
  }


  /**
   * Gets logged in customer.
   *
   * @return logged in customer
   */
  private Customer getLoggedInCustomer() {
    return customerComponent.getLoggedInCustomer();
  }

}
