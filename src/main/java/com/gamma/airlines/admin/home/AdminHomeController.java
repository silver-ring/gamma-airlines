/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.home;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;

/**
 * Class AdminHomeController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class AdminHomeController implements IController {

  /**
   * Show home.
   *
   * @return string
   */
  @Secured(RolesProperties.ROLE_ADMIN)
  @GetMapping(URLS.ADMIN_HOME)
  public String showHome() {
    final String adminHome = "admin/home";
    return adminHome;
  }


}
