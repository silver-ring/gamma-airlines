/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gamma.airlines.integration.json.AirlineOffer;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.BuyTicketsRequest;

// TODO: Auto-generated Javadoc
/**
 * Interface GammaAirlines.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@GammaApiClient
@RequestMapping(path = "gammaairlines")
public interface GammaAirlines {

  /**
   * List all offers.
   *
   * @return list
   */
  @RequestMapping(path = "offers", method = RequestMethod.GET)
  public List<AirlineOffer> listAllOffers();

  /**
   * Buy ticket.
   *
   * @param request request
   * @return airline ticket
   * @throws Exception exception
   */
  @RequestMapping(path = "tickets/buy", method = RequestMethod.POST)
  public AirlineTicket buyTicket(BuyTicketsRequest request) throws Exception;

  /**
   * List all tickets.
   *
   * @return list
   */
  @RequestMapping(path = "tickets", method = RequestMethod.GET)
  public List<AirlineTicket> listAllTickets();

}
