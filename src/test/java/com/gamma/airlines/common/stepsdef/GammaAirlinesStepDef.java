/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.stepsdef;

import java.util.List;

import org.mockito.BDDMockito;

import com.gamma.airlines.common.model.AvailableOffer;
import com.gamma.airlines.integration.GammaAirlines;
import com.gamma.airlines.integration.json.AirlineOffer;

// TODO: Auto-generated Javadoc
/**
 * Class GammaAirlinesStepDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class GammaAirlinesStepDef {

  /** gamma airlines. */
  private GammaAirlines gammaAirlines;

  /**
   * Instantiates a new gamma airlines step def.
   *
   * @param gammaAirlines gamma airlines
   */
  public GammaAirlinesStepDef(GammaAirlines gammaAirlines) {
    this.gammaAirlines = gammaAirlines;
  }

  /**
   * Available airline offers as following.
   *
   * @param availableOffers available offers
   * @throws Throwable throwable
   */
  public void available_airline_offers_as_following(List<AvailableOffer> availableOffers)
      throws Throwable {
    List<AirlineOffer> airlineOffers = AvailableOffer.mapToAirlineOffers(availableOffers);
    BDDMockito.given(gammaAirlines.listAllOffers()).willReturn(airlineOffers);
  }

  /**
   * Airline offers should be fetched.
   */
  public void airline_offers_should_be_fetched() {
    BDDMockito.verify(gammaAirlines).listAllOffers();
  }

}
