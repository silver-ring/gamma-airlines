/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.properties.URLS;

// TODO: Auto-generated Javadoc
/**
 * Class RegistrationController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class RegistrationController implements IController {

  /** Constant CURRENCIE_ATT_NAME. */
  private static final String CURRENCIE_ATT_NAME = "currencies";

  /** Constant REGISTRATION_VIEW. */
  private static final String REGISTRATION_VIEW = "anonymous/registration";

  /** registration service. */
  @Autowired
  private RegistrationService registrationService;

  /**
   * View registration page.
   *
   * @param registrationForm registration form
   * @param model model
   * @return string
   */
  @GetMapping(URLS.REGISTRATION)
  public String viewRegistrationPage(final RegistrationForm registrationForm, final Model model) {
    model.addAttribute(CURRENCIE_ATT_NAME, getAvailableCurrencies());
    return REGISTRATION_VIEW;
  }


  /**
   * Submit registration.
   *
   * @param registrationForm registration form
   * @param bindingResult binding result
   * @param model model
   * @return string
   */
  @PostMapping(URLS.REGISTRATION)
  public String submitRegistration(@Valid RegistrationForm registrationForm,
      BindingResult bindingResult, Model model) {

    final String SUCCESSFUL_REGISTRATION_VIEW = "anonymous/successful_registration";

    if (bindingResult.hasErrors()) {
      model.addAttribute(CURRENCIE_ATT_NAME, getAvailableCurrencies());
      return REGISTRATION_VIEW;
    }
    registrationService.registerNewCustomer(registrationForm);
    return SUCCESSFUL_REGISTRATION_VIEW;
  }

  /**
   * Gets available currencies.
   *
   * @return available currencies
   */
  private Currency[] getAvailableCurrencies() {
    return Currency.values();
  }

}
