/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;


// TODO: Auto-generated Javadoc
/**
 * Class PasswordMatchValidator.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Component
class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegistrationForm> {


  /*
   * (non-Javadoc)
   * 
   * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
   */
  @Override
  public void initialize(final PasswordMatch constraintAnnotation) {}

  /*
   * (non-Javadoc)
   * 
   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
   * javax.validation.ConstraintValidatorContext)
   */
  @Override
  public boolean isValid(final RegistrationForm registrationForm,
      final ConstraintValidatorContext context) {

    final String password = registrationForm.getPassword();
    final String passwordConfirmation = registrationForm.getPasswordConfirmation();

    boolean isPasswordMatch = StringUtils.equals(password, passwordConfirmation);

    if (!isPasswordMatch) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Password and Passowrd Confirmation must match")
          .addPropertyNode("passwordConfirmation").addConstraintViolation();
      return false;
    }
    return true;


  }

}
