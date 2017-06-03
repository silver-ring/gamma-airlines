/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gamma.airlines.integration.json.Account;
import com.gamma.airlines.integration.json.CreateAccountRequest;
import com.gamma.airlines.integration.json.DepositWithdrawRequest;

// TODO: Auto-generated Javadoc
/**
 * Interface Paypallets.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@GammaApiClient
@RequestMapping(path = "paypallets")
public interface Paypallets {

  /**
   * Creates the new account.
   *
   * @param request request
   * @return account
   */
  @RequestMapping(path = "account", method = RequestMethod.POST)
  public Account createNewAccount(CreateAccountRequest request);

  /**
   * List all accounts.
   *
   * @return list
   */
  @RequestMapping(path = "accounts", method = RequestMethod.GET)
  public List<Account> listAllAccounts();

  /**
   * Deposit money into account.
   *
   * @param request request
   * @return account
   */
  @RequestMapping(path = "account/deposit", method = RequestMethod.POST)
  public Account depositMoneyIntoAccount(DepositWithdrawRequest request);

}
