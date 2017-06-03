/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.email.purchasingorder;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.Message;

import org.assertj.core.api.Assertions;
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
import com.gamma.airlines.common.model.AvailablePurchasingOrder;
import com.gamma.airlines.common.stepsdef.PageAccessStepsDef;
import com.gamma.airlines.integration.GammaAirlines;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class EmailPurchasingOrderStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class EmailPurchasingOrderStepsDef extends BaseTest {


  /** customer repository. */
  @Autowired
  @MockBean
  @Qualifier("customerRepository")
  private CustomerRepository customerRepository;

  /** gamma airlines. */
  @Autowired
  @MockBean
  private GammaAirlines gammaAirlines;

  /** email purchasing order repository. */
  @Autowired
  @MockBean
  private EmailPurchasingOrderRepository emailPurchasingOrderRepository;


  /** page access steps. */
  private PageAccessStepsDef pageAccessSteps;


  /** test smtp. */
  private GreenMail testSmtp;

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
    ServerSetup serverSetup = new ServerSetup(25, "localhost", "smtp");
    testSmtp = new GreenMail(serverSetup);
    testSmtp.start();
  }

  /**
   * Cleanup.
   */
  @PreDestroy
  public void cleanup() {
    testSmtp.stop();
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
   * @param customerData customer data
   * @throws Throwable throwable
   */
  @Given("^customer with the following data$")
  public void customer_with_the_following_data(List<Customer> customerData) throws Throwable {
    BDDMockito.given(customerRepository.findByUsername(Mockito.anyString()))
        .willReturn(customerData.get(0));
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
    BDDMockito.given(emailPurchasingOrderRepository.findById(Mockito.anyLong()))
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
   * User should be able to access the page with no content.
   *
   * @throws Throwable throwable
   */
  @Then("^user should be able to access the page with no content$")
  public void user_should_be_able_to_access_the_page_with_no_content() throws Throwable {
    pageAccessSteps.user_should_be_able_to_access_the_page_with_no_content();
  }

  /**
   * Email should be sended.
   *
   * @throws Throwable throwable
   */
  @Then("^email should be sended$")
  public void email_should_be_sended() throws Throwable {
    Assertions.assertThat(testSmtp.waitForIncomingEmail(5000, 1)).isTrue();
    Message[] messages = testSmtp.getReceivedMessages();
    Assertions.assertThat(messages.length).isEqualTo(1);
    Assertions.assertThat(GreenMailUtil.getBody(messages[0])).isNotBlank();
  }


}
