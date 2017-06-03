/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.gamma.airlines.common.IForm;
import com.gamma.airlines.common.enums.Currency;

import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Class RegistrationForm.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@PasswordMatch(groups = PasswordMatchValidationGroup.class)
@GroupSequence({RegistrationForm.class, PasswordMatchValidationGroup.class})

/**
 * Instantiates a new registration form.
 */

/**
 * Instantiates a new registration form.
 */

/**
 * Instantiates a new registration form.
 */

/**
 * Instantiates a new registration form.
 */
@Data
class RegistrationForm implements IForm {

  /** username. */
  @NotBlank
  @UniqueUsername
  private String username;

  /** password. */
  @NotBlank
  private String password;

  /** password confirmation. */
  @NotBlank
  private String passwordConfirmation;

  /** email. */
  @NotBlank
  @Email
  @UniqueEmail
  private String email;

  /** full name. */
  @NotBlank
  private String fullName;

  /** currency. */
  @NotNull
  private Currency currency;


}
