/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * Class UniqueUsernameValidator.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Component
class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  /** registration service. */
  @Autowired
  private RegistrationService registrationService;

  /*
   * (non-Javadoc)
   * 
   * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
   */
  @Override
  public void initialize(UniqueUsername constraintAnnotation) {

  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
   * javax.validation.ConstraintValidatorContext)
   */
  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    return !registrationService.checkIfUsernameExist(username);
  }

}
