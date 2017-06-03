/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.purchasingorders;

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
 * Class PurchasingOrdersController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class PurchasingOrdersController implements IController {


  /** purchasing orders service. */
  @Autowired
  private PurchasingOrdersService purchasingOrdersService;

  /**
   * Show all purchasing orders.
   *
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_ADMIN)
  @GetMapping(URLS.ADMIN_PURCHASING_ORDERS)
  public String showAllPurchasingOrders(Model model) {

    final String purchasingOrdersView = "admin/purchasing_orders";
    final String ordersAttName = "orders";

    List<PurchasingOrderModel> purchasingOrderRow =
        purchasingOrdersService.findAllPurchasingOrders();

    model.addAttribute(ordersAttName, purchasingOrderRow);
    return purchasingOrdersView;
  }


}
