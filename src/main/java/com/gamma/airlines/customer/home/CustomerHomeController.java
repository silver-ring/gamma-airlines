/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.home;

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
 * Class CustomerHomeController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class CustomerHomeController implements IController {

  /** customer home service. */
  @Autowired
  private CustomerHomeService customerHomeService;

  /**
   * View home.
   *
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @GetMapping(URLS.CUSTOMER_HOME)
  public String viewHome(final Model model) {

    final List<AirlineOfferModel> airlineOfferRows = customerHomeService.fetchAllOffers();

    final String OFFERS_ATT_NAME = "offers";
    final String CUSTOMER_HOME_VIEW = "customer/home";

    model.addAttribute(OFFERS_ATT_NAME, airlineOfferRows);

    return CUSTOMER_HOME_VIEW;
  }


}
