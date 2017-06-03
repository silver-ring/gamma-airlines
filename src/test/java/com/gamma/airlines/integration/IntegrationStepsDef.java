/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.integration;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.gamma.airlines.BaseTest;
import com.gamma.airlines.common.model.AirlineTicketData;
import com.gamma.airlines.common.model.BuyTicketsData;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.BuyTicketsRequest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * Class IntegrationStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class IntegrationStepsDef extends BaseTest {

  /** api forest. */
  @Autowired
  private ApiForest apiForest;

  /** gamma airlines. */
  @Autowired
  private GammaAirlines gammaAirlines;

  /** buy tickets request. */
  private BuyTicketsRequest buyTicketsRequest;

  /** airline ticket. */
  private AirlineTicket airlineTicket;

  /**
   * Clean api.
   *
   * @throws Throwable throwable
   */
  @Given("^clean api$")
  public void clean_api() throws Throwable {
    apiForest.resetAPIState();
  }

  /**
   * Test request with the following data.
   *
   * @param buyTicketsDatas buy tickets datas
   * @throws Throwable throwable
   */
  @Given("^tickets with the following data$")
  public void test_request_with_the_following_data(List<BuyTicketsData> buyTicketsDatas)
      throws Throwable {
    buyTicketsRequest = buyTicketsDatas.get(0).mapToBuyTicketsRequest();
  }

  /**
   * Try to call buy ticket service.
   *
   * @throws Throwable throwable
   */
  @When("^try to call buy ticket service$")
  public void try_to_call_buy_ticket_service() throws Throwable {
    airlineTicket = gammaAirlines.buyTicket(buyTicketsRequest);
  }

  /**
   * Should recive the follwoing data.
   *
   * @param airlineTicketDatas airline ticket datas
   * @throws Throwable throwable
   */
  @Then("^should recive the follwoing data$")
  public void should_recive_the_follwoing_data(List<AirlineTicketData> airlineTicketDatas)
      throws Throwable {
    Assertions.assertThat(airlineTicket).isEqualTo(airlineTicketDatas.get(0).mapToAirlineTicket());
  }



}
