/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.components.UsersComponent;

// TODO: Auto-generated Javadoc
/**
 * Class LoginService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class LoginService implements IService {

  /** users component. */
  @Autowired
  private UsersComponent usersComponent;

  /**
   * Gets logged in user role.
   *
   * @return logged in user role
   */
  String getLoggedInUserRole() {
    return usersComponent.getLoggedInUserRole();
  }

}
