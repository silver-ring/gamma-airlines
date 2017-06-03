/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class PurchasingController implements IController {

  /** purchasing service. */
  @Autowired
  private PurchasingService purchasingService;

  /**
   * Show purchasing order details.
   *
   * @param purchaseRequest purchase request
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @GetMapping(URLS.CUSTOMER_PURCHASE_ORDER_DETAILS)
  public String showPurchasingOrderDetails(final PurchaseRequest purchaseRequest,
      final Model model) {
    final String PURCHASING_DETAILS_ATT_NAME = "purchasingDetails";
    final String PURCHASING_ORDER_VIEW = "customer/purchasing";

    PurchasingDetailsModel purchasingDetails =
        purchasingService.getPurchasingDetails(purchaseRequest);
    model.addAttribute(PURCHASING_DETAILS_ATT_NAME, purchasingDetails);
    return PURCHASING_ORDER_VIEW;
  }

  /**
   * Purchase ticket.
   *
   * @param purchasingForm purchasing form
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @PostMapping(URLS.CUSTOMER_PURCHASE_TICKET)
  public String purchaseTicket(PurchasingForm purchasingForm, Model model) {

    final String PURCHASING_ORDER_SUMMARY_ATT_NAME = "purchasingOrderSummary";
    final String PURCHASING_ORDER_SUMMARY_VIEW = "customer/purchasing_order_summary";

    PurchasingOrderSummaryModel purchasingOrderSummary =
        purchasingService.buyTicket(purchasingForm);
    model.addAttribute(PURCHASING_ORDER_SUMMARY_ATT_NAME, purchasingOrderSummary);
    return PURCHASING_ORDER_SUMMARY_VIEW;
  }

}
