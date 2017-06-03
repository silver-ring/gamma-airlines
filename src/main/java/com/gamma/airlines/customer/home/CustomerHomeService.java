/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.integration.GammaAirlines;
import com.gamma.airlines.integration.json.AirlineOffer;

// TODO: Auto-generated Javadoc
/**
 * Class CustomerHomeService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class CustomerHomeService implements IService {

  /** gamma airlines. */
  @Autowired
  private GammaAirlines gammaAirlines;

  /**
   * Fetch all offers.
   *
   * @return list
   */
  List<AirlineOfferModel> fetchAllOffers() {
    List<AirlineOffer> airlineOffers = gammaAirlines.listAllOffers();
    return AirlineOfferModel.mapFromAirlineOffers(airlineOffers);
  }



}
