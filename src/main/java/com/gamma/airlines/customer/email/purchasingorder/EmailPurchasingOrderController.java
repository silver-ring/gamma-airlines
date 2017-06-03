/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.email.purchasingorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

// TODO: Auto-generated Javadoc
/**
 * Class EmailPurchasingOrderController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RestController
class EmailPurchasingOrderController implements IController {


  /** email purchasing order service. */
  @Autowired
  private EmailPurchasingOrderService emailPurchasingOrderService;

  /**
   * Email purchsing order.
   *
   * @param purchasingOrderEmailRequest purchasing order email request
   * @param model model
   * @return response entity
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @GetMapping(URLS.CUSTOMER_EMAIL_PURCHASING_ORDER)
  public ResponseEntity<?> emailPurchsingOrder(
      final EmailPurchasingOrderRequest purchasingOrderEmailRequest, final Model model) {

    final String emailViewName = "customer/purchsing_order_email";

    final PurchasingOrderEmailModel purchasingOrderEmail =
        emailPurchasingOrderService.findPurchasingOrder(purchasingOrderEmailRequest);

    final ModelAndView emailModelAndView = new ModelAndView();
    emailModelAndView.setViewName(emailViewName);
    emailModelAndView.addObject("order", purchasingOrderEmail);
    emailPurchasingOrderService.sendPurchasingEmail(emailModelAndView);

    return ResponseEntity.noContent().build();
  }


}
