/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gamma.airlines.integration.json.ExchangeCurrenciesRequest;
import com.gamma.airlines.integration.json.MonetaryAmount;

// TODO: Auto-generated Javadoc
/**
 * Interface MoneyExchange.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@GammaApiClient
@RequestMapping(path = "moneyexchange")
public interface MoneyExchange {

  /**
   * Exchange currencies.
   *
   * @param request request
   * @return monetary amount
   */
  @RequestMapping(path = "exchange", method = RequestMethod.POST)
  public MonetaryAmount exchangeCurrencies(ExchangeCurrenciesRequest request);

}
