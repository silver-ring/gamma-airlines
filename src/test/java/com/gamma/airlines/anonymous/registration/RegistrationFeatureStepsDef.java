/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.domain.Authorities;
import com.gamma.airlines.common.domain.Authorities.Authority;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;
import com.gamma.airlines.integration.MoneyExchange;
import com.gamma.airlines.integration.Paypallets;
import com.gamma.airlines.integration.json.Account;
import com.gamma.airlines.integration.json.CreateAccountRequest;
import com.gamma.airlines.integration.json.ExchangeCurrenciesRequest;
import com.gamma.airlines.integration.json.MonetaryAmount;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class RegistrationFeatureStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class RegistrationFeatureStepsDef extends BaseTest {

  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;

  /** mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /** result actions. */
  private ResultActions resultActions;

  /** user request post processor. */
  private UserRequestPostProcessor userRequestPostProcessor;


  /** registration customer repository. */
  @Autowired
  @MockBean
  private RegistrationCustomerRepository registrationCustomerRepository;

  /** paypallets. */
  @Autowired
  @MockBean
  private Paypallets paypallets;

  /** money exchange. */
  @Autowired
  @MockBean
  private MoneyExchange moneyExchange;

  /** authorities entity repository. */
  @Autowired
  @MockBean
  private RegistrationAuthoritiesRepository authoritiesEntityRepository;


  /** create customer. */
  private Customer createCustomer;

  /**
   * Inits the.
   */
  @PostConstruct
  public void init() {
    pageAccessSteps = new PageAccessStepsDef(mockMvc, resultActions, userRequestPostProcessor);
  }

  /**
   * Logged in user with role.
   *
   * @param role role
   * @throws Throwable throwable
   */
  @Given("^logged in user with role \"([^\"]*)\"$")
  public void logged_in_user_with_role(String role) throws Throwable {
    pageAccessSteps.logged_in_user_with_role(role);
  }

  /**
   * Entered email is not exist.
   *
   * @throws Throwable throwable
   */
  @Given("^entered email is not exist$")
  public void entered_email_is_not_exist() throws Throwable {
    BDDMockito.given(registrationCustomerRepository.existsByEmail(Mockito.anyString()))
        .willReturn(false);
  }

  /**
   * Entered username is not exist.
   *
   * @throws Throwable throwable
   */
  @Given("^entered username is not exist$")
  public void entered_username_is_not_exist() throws Throwable {
    BDDMockito.given(registrationCustomerRepository.existsByUsername(Mockito.anyString()))
        .willReturn(false);
  }


  /**
   * Try to access page.
   *
   * @param pageUrl page url
   * @throws Throwable throwable
   */
  @When("^try to access \"([^\"]*)\" page$")
  public void try_to_access_page(String pageUrl) throws Throwable {
    pageAccessSteps.try_to_access_page(pageUrl);
  }

  /**
   * User should be able to access the page.
   *
   * @throws Throwable throwable
   */
  @Then("^user should be able to access the page$")
  public void user_should_be_able_to_access_the_page() throws Throwable {
    pageAccessSteps.user_should_be_able_to_access_the_page();
  }

  /**
   * View should be display.
   *
   * @param view view
   * @throws Throwable throwable
   */
  @Then("^view \"([^\"]*)\" should be display$")
  public void view_should_be_display(String view) throws Throwable {
    pageAccessSteps.view_should_be_display(view);
  }

  /**
   * Customer will be created with the following data.
   *
   * @param customerData customer data
   * @throws Throwable throwable
   */
  @Given("^customer will be created with the following data$")
  public void customer_will_be_created_with_the_following_data(List<Customer> customerData)
      throws Throwable {
    createCustomer = customerData.get(0);
    BDDMockito.given(registrationCustomerRepository.save(Mockito.any(Customer.class)))
        .willReturn(customerData.get(0));
  }

  /**
   * Account will be created with id.
   *
   * @param accountId account id
   * @param amount amount
   * @param currency currency
   * @throws Throwable throwable
   */
  @Given("^account will be created with id \"([^\"]*)\" has \"([^\"]*)\" amount in \"([^\"]*)\" currency$")
  public void account_will_be_created_with_id(String accountId, Double amount, Currency currency)
      throws Throwable {
    MonetaryAmount balance = MonetaryAmount.builder().amount(amount).currency(currency).build();
    Account account = Account.builder().balance(balance).id(accountId).build();
    BDDMockito.given(paypallets.createNewAccount(Mockito.any(CreateAccountRequest.class)))
        .willReturn(account);
  }

  /**
   * Initial deposit should exchange as following.
   *
   * @param monetaryAmountData monetary amount data
   * @throws Throwable throwable
   */
  @Given("^initial deposit should exchange as following$")
  public void initial_deposit_should_exchange_as_following(List<MonetaryAmount> monetaryAmountData)
      throws Throwable {
    BDDMockito.given(moneyExchange.exchangeCurrencies(Mockito.any(ExchangeCurrenciesRequest.class)))
        .willReturn(monetaryAmountData.get(0));
  }

  /**
   * Try to submit to with the following data.
   *
   * @param pageUrl page url
   * @param formParms form parms
   * @throws Throwable throwable
   */
  @When("^try to submit to \"([^\"]*)\" with the following data$")
  public void try_to_submit_to_with_the_following_data(String pageUrl,
      Map<String, String> formParms) throws Throwable {
    pageAccessSteps.try_to_submit_to_with_the_following_data(pageUrl, formParms);
  }

  /**
   * Customer should be created with the following data.
   *
   * @param customerData customer data
   * @throws Throwable throwable
   */
  @Then("^Customer should be created with the following data$")
  public void customer_should_be_created_with_the_following_data(List<Customer> customerData)
      throws Throwable {
    BDDMockito.verify(registrationCustomerRepository).save(customerData.get(0));
  }

  /**
   * With authority.
   *
   * @param authority authority
   * @throws Throwable throwable
   */
  @Then("^with authority \"([^\"]*)\"$")
  public void with_authority(Authority authority) throws Throwable {
    Authorities authorities =
        Authorities.builder().authority(authority).users(createCustomer).build();
    BDDMockito.verify(authoritiesEntityRepository).save(authorities);
  }

  /**
   * Account should be created in currency.
   *
   * @param currency currency
   * @throws Throwable throwable
   */
  @Then("^Account should be created in \"([^\"]*)\" currency$")
  public void account_should_be_created_in_currency(Currency currency) throws Throwable {
    CreateAccountRequest createAccountRequest =
        CreateAccountRequest.builder().currency(currency).build();
    BDDMockito.verify(paypallets).createNewAccount(createAccountRequest);
  }


  /**
   * Initial deposit with amount should be exchange from currency to currency.
   *
   * @param amount amount
   * @param currency currency
   * @param targetCurrency target currency
   * @throws Throwable throwable
   */
  @Then("^initial deposit with amount \"([^\"]*)\" should be exchange from \"([^\"]*)\" currency to \"([^\"]*)\" currency$")
  public void initial_deposit_with_amount_should_be_exchange_from_currency_to_currency(
      Double amount, Currency currency, Currency targetCurrency) throws Throwable {
    MonetaryAmount monetaryAmount =
        MonetaryAmount.builder().amount(amount).currency(currency).build();
    ExchangeCurrenciesRequest exchangeCurrenciesRequest = ExchangeCurrenciesRequest.builder()
        .monetaryAmount(monetaryAmount).targetCurrency(targetCurrency).build();
    BDDMockito.verify(moneyExchange).exchangeCurrencies(exchangeCurrenciesRequest);
  }

  /**
   * Model with attribute should be exist with the following values.
   *
   * @param attribute attribute
   * @param currencies currencies
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"([^\"]*)\" should be exist with the following values$")
  public void model_with_attribute_should_be_exist_with_the_following_values(String attribute,
      List<Currency> currencies) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(attribute,
        currencies.toArray());
  }

  /**
   * Model should has errors.
   *
   * @param numberOfErrors number of errors
   * @throws Throwable throwable
   */
  @Then("^model should has (\\d+) errors$")
  public void model_should_has_errors(int numberOfErrors) throws Throwable {
    pageAccessSteps.model_should_has_errors(numberOfErrors);
  }

  /**
   * Entered username is exist.
   *
   * @throws Throwable throwable
   */
  @Given("^entered username is exist$")
  public void entered_username_is_exist() throws Throwable {
    BDDMockito.given(registrationCustomerRepository.existsByUsername(Mockito.anyString()))
        .willReturn(true);
  }

  /**
   * Entered email is exist.
   *
   * @throws Throwable throwable
   */
  @Given("^entered email is exist$")
  public void entered_email_is_exist() throws Throwable {
    BDDMockito.given(registrationCustomerRepository.existsByEmail(Mockito.anyString()))
        .willReturn(true);
  }


  /**
   * Authority should be granted as.
   *
   * @param authority authority
   * @throws Throwable throwable
   */
  @Then("^authority should be granted as \"([^\"]*)\"$")
  public void authority_should_be_granted_as(Authority authority) throws Throwable {
    Authorities authorities =
        Authorities.builder().authority(authority).users(createCustomer).build();
    BDDMockito.verify(authoritiesEntityRepository).save(authorities);
  }


}
