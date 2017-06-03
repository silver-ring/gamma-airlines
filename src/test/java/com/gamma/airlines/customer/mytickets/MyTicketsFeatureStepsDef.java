/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.mytickets;

import java.util.List;

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
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class MyTicketsFeatureStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class MyTicketsFeatureStepsDef extends BaseTest {


  /** customer repository. */
  @Autowired
  @MockBean
  @Qualifier("customerRepository")
  private CustomerRepository customerRepository;

  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;


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
   * Customer has tickets as following.
   *
   * @param airlineTicketOrders airline ticket orders
   * @throws Throwable throwable
   */
  @Given("^customer has tickets as following$")
  public void customer_has_tickets_as_following(List<PurchasingOrder> airlineTicketOrders)
      throws Throwable {
    Customer customer = new Customer();
    customer.setAirlineTicketOrders(airlineTicketOrders);
    BDDMockito.given(customerRepository.findByUsername(Mockito.anyString())).willReturn(customer);

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
   * Model with attribute should be exist with the following values.
   *
   * @param attribute attribute
   * @param orderModels order models
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"([^\"]*)\" should be exist with the following values$")
  public void model_with_attribute_should_be_exist_with_the_following_values(String attribute,
      List<OrderModel> orderModels) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(attribute,
        orderModels);
  }

}
