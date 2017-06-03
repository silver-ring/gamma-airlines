/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.export.purchasingorder;

import java.util.List;

import javax.annotation.PostConstruct;

import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.model.AvailablePurchasingOrder;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class ExportPurchasingOrderStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class ExportPurchasingOrderStepsDef extends BaseTest {

  /** purchasing order entity repository. */
  @Autowired
  @MockBean
  private ExportPurchasingOrderRepository purchasingOrderEntityRepository;


  /** mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /** result actions. */
  private ResultActions resultActions;

  /** user request post processor. */
  private UserRequestPostProcessor userRequestPostProcessor;

  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;


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
   * Customer has purchasing order as as following.
   *
   * @param purchasingOrderData purchasing order data
   * @throws Throwable throwable
   */
  @Given("^customer has purchasing order as following$")
  public void customer_has_purchasing_order_as_as_following(
      List<AvailablePurchasingOrder> purchasingOrderData) throws Throwable {
    PurchasingOrder purchasingOrder = purchasingOrderData.get(0).mapToPurchasingOrder();
    BDDMockito.given(purchasingOrderEntityRepository.findById(Mockito.anyLong()))
        .willReturn(purchasingOrder);
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
   * @param purchasingOrderPdfModelData purchasing order pdf model data
   * @throws Throwable throwable
   */
  @Then("^model with attribute \"([^\"]*)\" should be exist with the following values$")
  public void model_with_attribute_should_be_exist_with_the_following_values(String attribute,
      List<PurchasingOrderPdfModel> purchasingOrderPdfModelData) throws Throwable {
    pageAccessSteps.model_with_attribute_should_be_exist_with_the_following_values(attribute,
        purchasingOrderPdfModelData.toArray());
  }

  /**
   * Should be exported in format.
   *
   * @param exportFormat export format
   * @throws Throwable throwable
   */
  @Then("^should be exported in \"([^\"]*)\" format$")
  public void should_be_exported_in_format(String exportFormat) throws Throwable {
    pageAccessSteps.should_be_exported_in_format(exportFormat);
  }


}
