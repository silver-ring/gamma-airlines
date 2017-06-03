/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.Authorities;
import com.gamma.airlines.common.domain.Authorities.Authority;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.components.UsersComponent;
import com.gamma.airlines.integration.MoneyExchange;
import com.gamma.airlines.integration.Paypallets;
import com.gamma.airlines.integration.json.Account;
import com.gamma.airlines.integration.json.CreateAccountRequest;
import com.gamma.airlines.integration.json.DepositWithdrawRequest;
import com.gamma.airlines.integration.json.ExchangeCurrenciesRequest;
import com.gamma.airlines.integration.json.MonetaryAmount;

// TODO: Auto-generated Javadoc
/**
 * Class RegistrationService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class RegistrationService implements IService {

  /** customer entity repository. */
  @Autowired
  private RegistrationCustomerRepository customerEntityRepository;

  /** paypallets. */
  @Autowired
  private Paypallets paypallets;

  /** money exchange. */
  @Autowired
  private MoneyExchange moneyExchange;

  /** registration authorities repository. */
  @Autowired
  private RegistrationAuthoritiesRepository registrationAuthoritiesRepository;

  /** users component. */
  @Autowired
  private UsersComponent usersComponent;

  /**
   * Check if username exist.
   *
   * @param username username
   * @return true, if successful
   */
  boolean checkIfUsernameExist(String username) {
    return customerEntityRepository.existsByUsername(username);
  }

  /**
   * Check if email exist.
   *
   * @param email email
   * @return true, if successful
   */
  boolean checkIfEmailExist(String email) {
    return customerEntityRepository.existsByEmail(email);
  }

  /**
   * Register new customer.
   *
   * @param registrationForm registration form
   */
  void registerNewCustomer(RegistrationForm registrationForm) {
    Account account = createPaypalletsAccount(registrationForm);
    depositInitAmount(account);
    Customer newCustomer = createCustomer(registrationForm, account);
    granteCustomerAuthority(newCustomer);
  }

  /**
   * Creates the paypallets account.
   *
   * @param registrationForm registration form
   * @return account
   */
  private Account createPaypalletsAccount(RegistrationForm registrationForm) {
    CreateAccountRequest createAccountRequest =
        CreateAccountRequest.builder().currency(registrationForm.getCurrency()).build();
    return paypallets.createNewAccount(createAccountRequest);
  }

  /**
   * Deposit init amount.
   *
   * @param account account
   */
  private void depositInitAmount(Account account) {
    MonetaryAmount monetaryAmount = exchangeInitAmountToAccountCurrency(account);
    depositIntoAccount(account, monetaryAmount);
  }

  /**
   * Exchange init amount to account currency.
   *
   * @param account account
   * @return monetary amount
   */
  private MonetaryAmount exchangeInitAmountToAccountCurrency(Account account) {
    MonetaryAmount monetaryAmount = getInitAmount();
    Currency accountCurrency = getAccountCurrency(account);
    return exchangeMonetaryAmount(monetaryAmount, accountCurrency);
  }

  /**
   * Gets inits the amount.
   *
   * @return inits the amount
   */
  private MonetaryAmount getInitAmount() {
    return MonetaryAmount.builder().amount(1000D).currency(Currency.USD).build();
  }

  /**
   * Gets account currency.
   *
   * @param account account
   * @return account currency
   */
  private Currency getAccountCurrency(Account account) {
    return account.getBalance().getCurrency();
  }

  /**
   * Exchange monetary amount.
   *
   * @param monetaryAmount monetary amount
   * @param targetCurrency target currency
   * @return monetary amount
   */
  private MonetaryAmount exchangeMonetaryAmount(MonetaryAmount monetaryAmount,
      Currency targetCurrency) {
    ExchangeCurrenciesRequest exchangeCurrenciesRequest = ExchangeCurrenciesRequest.builder()
        .monetaryAmount(monetaryAmount).targetCurrency(targetCurrency).build();
    return moneyExchange.exchangeCurrencies(exchangeCurrenciesRequest);
  }

  /**
   * Deposit into account.
   *
   * @param account account
   * @param monetaryAmount monetary amount
   */
  private void depositIntoAccount(Account account, MonetaryAmount monetaryAmount) {
    DepositWithdrawRequest depositWithdrawRequest = DepositWithdrawRequest.builder()
        .accountId(account.getId()).monetaryAmount(monetaryAmount).build();
    paypallets.depositMoneyIntoAccount(depositWithdrawRequest);
  }

  /**
   * Creates the customer.
   *
   * @param registrationForm registration form
   * @param account account
   * @return customer
   */
  private Customer createCustomer(RegistrationForm registrationForm, Account account) {
    String paypalAccountId = account.getId();
    String hashedPassword = usersComponent.hashRawPassword(registrationForm.getPassword());
    Customer customer = Customer.builder().username(registrationForm.getUsername())
        .password(hashedPassword).email(registrationForm.getEmail())
        .fullName(registrationForm.getFullName()).paypalletsAccountId(paypalAccountId).build();
    return customerEntityRepository.save(customer);
  }

  /**
   * Grante customer authority.
   *
   * @param customer customer
   */
  private void granteCustomerAuthority(Customer customer) {
    Authorities authorities =
        Authorities.builder().users(customer).authority(Authority.ROLE_CUSTOMER).build();
    registrationAuthoritiesRepository.save(authorities);
  }


}
