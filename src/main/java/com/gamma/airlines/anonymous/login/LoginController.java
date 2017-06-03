/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

// TODO: Auto-generated Javadoc
/**
 * Class LoginController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class LoginController implements IController {

  /** Constant LOGIN_VIEW. */
  private static final String LOGIN_VIEW = "anonymous/login";

  /** login service. */
  @Autowired
  private LoginService loginService;

  /**
   * View login.
   *
   * @return string
   */
  @GetMapping(URLS.LOGIN)
  public String viewLogin() {
    return LOGIN_VIEW;
  }

  /**
   * Home.
   *
   * @return string
   */
  @GetMapping(URLS.Home)
  public String home() {
    String userRole = loginService.getLoggedInUserRole();
    return getLoggedInUserHomeUrl(userRole);
  }

  /**
   * Gets logged in user home url.
   *
   * @param userRole user role
   * @return logged in user home url
   */
  private String getLoggedInUserHomeUrl(final String userRole) {
    final String adminHomeRedirect = "redirect:/admin/home";
    final String customerHomeRedirect = "redirect:/customer/home";
    switch (userRole) {
      case RolesProperties.ROLE_ADMIN:
        return adminHomeRedirect;
      case RolesProperties.ROLE_CUSTOMER:
        return customerHomeRedirect;
      default:
        return LOGIN_VIEW;
    }
  }

}
