/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.CustomerRepository;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.model.AvailableOffer;
import com.gamma.airlines.common.model.CreatedOffer;
import com.gamma.airlines.common.stepsdef.GammaAirlinesStepDef;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;
import com.gamma.airlines.integration.GammaAirlines;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.BuyTicketsRequest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingFeatureStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class PurchasingFeatureStepsDef extends BaseTest {


  /** customer repository. */
  @Autowired
  @MockBean
  @Qualifier("customerRepository")
  private CustomerRepository customerRepository;

  /** gamma airlines. */
  @Autowired
  @MockBean
  private GammaAirlines gammaAirlines;

  /** purchasing order entity repository. */
  @Autowired
  @MockBean
  private PurchasingRepository purchasingOrderEntityRepository;


  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;

  /** gamma airlines step def. */
  private GammaAirlinesStepDef gammaAirlinesStepDef;

  /** mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /** result actions. */
  private ResultActions resultActions;

  /** user request post processor. */
  private UserRequestPostProcessor userRequestPostProcessor;

  /**
   * Inits the.
   */
  @PostConstruct
  public void init() {
    pageAccessSteps = new PageAccessStepsDef(mockMvc, resultActions, userRequestPostProcessor);
    gammaAirlinesStepDef = new GammaAirlinesStepDef(gammaAirlines);
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
   * Customer with the following data.
   *
   * @param customer customer
   * @throws Throwable throwable
   */
  @Given("^customer with the following data$")
  public void customer_with_the_following_data(List<Customer> customer) throws Throwable {
    BDDMockito.given(customerRepository.findByUsername(Mockito.anyString()))
        .willReturn(customer.get(0));
  }

  /**
   * Available airline offers as following.
   *
   * @param availableOffers available offers
   * @throws Throwable throwable
   */
  @Given("^available airline offers as following$")
  public void available_airline_offers_as_following(List<AvailableOffer> availableOffers)
      throws Throwable {
    gammaAirlinesStepDef.available_airline_offers_as_following(availableOffers);
  }

  /**
   * Created order should be as following.
   *
   * @param createdOfferData created offer data
   * @throws Throwable throwable
   */
  @Given("^created order should be as following$")
  public void created_order_should_be_as_following(List<CreatedOffer> createdOfferData)
      throws Throwable {
    AirlineTicket airlineTicket = CreatedOffer.mapToAirlineTicket(createdOfferData.get(0));
    BDDMockito.given(gammaAirlines.buyTicket(Mockito.any(BuyTicketsRequest.class)))
        .willReturn(airlineTicket);
  }

  /**
   * Created purchasing order for customer named as following.
   *
   * @param customerFullName customer full name
   * @param purchasingOrderData purchasing order data
   * @throws Throwable throwable
   */
  @Given("^created purchasing order for customer named \"([^\"]*)\" as following$")
  public void created_purchasing_order_for_customer_named_as_following(String customerFullName,
      List<PurchasingOrder> purchasingOrderData) throws Throwable {
    Customer customer = Customer.builder().fullName(customerFullName).build();
    purchasingOrderData.get(0).setCustomer(customer);
    BDDMockito.given(purchasingOrderEntityRepository.save(Mockito.any(PurchasingOrder.class)))
        .willReturn(purchasingOrderData.get(0));
  }


  /**
   * Created order should be as following will return error.
   *
   * @throws Throwable throwable
   */
  @Given("^created order should be as following will return error$")
  public void created_order_should_be_as_following_will_return_error() throws Throwable {
    BDDMockito.given(gammaAirlines.buyTicket(Mockito.any(BuyTicketsRequest.class)))
        .willThrow(new Exception());
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
   * User should be able to access the page with bad request.
   *
   * @throws Throwable throwable
   */
  @Then("^user should be able to access the page with bad request$")
  public void user_should_be_able_to_access_the_page_with_bad_request() throws Throwable {
    pageAccessSteps.user_should_be_able_to_access_the_page_with_bad_request();
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
   * Model with attribute purchasing details should be exist with the following values.
   *
   * @param purchasingDetailsModel purchasing details model
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"purchasingDetails\" should be exist with the following values$")
  public void model_with_attribute_purchasingDetails_should_be_exist_with_the_following_values(
      List<PurchasingDetailsModel> purchasingDetailsModel) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(
        "purchasingDetails", purchasingDetailsModel.get(0));
  }

  /**
   * Model with attribute purchasing order summary should be exist with the following values.
   *
   * @param purchasingOrderSummaryModel purchasing order summary model
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"purchasingOrderSummary\" should be exist with the following values$")
  public void model_with_attribute_purchasingOrderSummary_should_be_exist_with_the_following_values(
      List<PurchasingOrderSummaryModel> purchasingOrderSummaryModel) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(
        "purchasingOrderSummary", purchasingOrderSummaryModel.get(0));
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
   * User should be able to access the page with no content.
   *
   * @throws Throwable throwable
   */
  @Then("^user should be able to access the page with no content$")
  public void user_should_be_able_to_access_the_page_with_no_content() throws Throwable {
    pageAccessSteps.user_should_be_able_to_access_the_page_with_no_content();
  }


  /**
   * Model should have error message.
   *
   * @param message message
   * @throws Throwable throwable
   */
  @Then("^model should have error message \"([^\"]*)\"$")
  public void model_should_have_error_message(String message) throws Throwable {
    pageAccessSteps.model_should_have_error_message(message);
  }

}
