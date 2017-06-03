/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.home;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.model.AvailableOffer;
import com.gamma.airlines.common.stepsdef.GammaAirlinesStepDef;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;
import com.gamma.airlines.integration.GammaAirlines;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class CustomerHomeFeatureStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class CustomerHomeFeatureStepsDef extends BaseTest {


  /** gamma airlines. */
  @Autowired
  @MockBean
  private GammaAirlines gammaAirlines;


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
   * Airline offers should be fetched.
   *
   * @throws Throwable throwable
   */
  @Then("^airline offers should be fetched$")
  public void airline_offers_should_be_fetched() throws Throwable {
    gammaAirlinesStepDef.airline_offers_should_be_fetched();
  }


  /**
   * Model with attribute should be exist with the following values.
   *
   * @param attribute attribute
   * @param airlineOfferModels airline offer models
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"([^\"]*)\" should be exist with the following values$")
  public void model_with_attribute_should_be_exist_with_the_following_values(String attribute,
      List<AirlineOfferModel> airlineOfferModels) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(attribute,
        airlineOfferModels);
  }

}
