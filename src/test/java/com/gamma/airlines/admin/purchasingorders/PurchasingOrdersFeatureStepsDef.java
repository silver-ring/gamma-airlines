/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.purchasingorders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingOrdersFeatureStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class PurchasingOrdersFeatureStepsDef extends BaseTest {

  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;

  /** mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /** result actions. */
  private ResultActions resultActions;

  /** user request post processor. */
  private UserRequestPostProcessor userRequestPostProcessor;


  /** purchasing order entity repository. */
  @Autowired
  @MockBean
  private PurchasingOrdersRepository purchasingOrderEntityRepository;


  /**
   * Inits the.
   */
  @PostConstruct
  public void init() {
    pageAccessSteps = new PageAccessStepsDef(mockMvc, resultActions, userRequestPostProcessor);
  }

  /**
   * The following purchasing orders had been recorded.
   *
   * @param purchasingOrders purchasing orders
   * @throws Throwable throwable
   */
  @Given("^the following purchasing orders had been recorded$")
  public void the_following_purchasing_orders_had_been_recorded(
      List<PurchasingOrder> purchasingOrders) throws Throwable {
    given(purchasingOrderEntityRepository.findAll()).willReturn(purchasingOrders);
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
   * Purchasing orders should be fetched.
   *
   * @throws Throwable throwable
   */
  @Then("^purchasing orders should be fetched$")
  public void purchasing_orders_should_be_fetched() throws Throwable {
    verify(purchasingOrderEntityRepository).findAll();
  }

  /**
   * Model with attribute should be exist with the following values.
   *
   * @param orders orders
   * @param purchasingOrderModels purchasing order models
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"([^\"]*)\" should be exist with the following values$")
  public void model_with_attribute_should_be_exist_with_the_following_values(String orders,
      List<PurchasingOrderModel> purchasingOrderModels) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(orders,
        purchasingOrderModels);
  }


}
