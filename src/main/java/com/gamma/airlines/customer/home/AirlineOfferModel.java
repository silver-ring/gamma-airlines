/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.home;

import java.util.List;
import java.util.stream.Collectors;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.enums.Currency;
import com.gamma.airlines.integration.json.AirlineOffer;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * Class AirlineOfferModel.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Builder
class AirlineOfferModel implements IModel {

  /** from. */
  @NonNull
  private String from;

  /** to. */
  @NonNull
  private String to;

  /** price. */
  @NonNull
  private Double price;

  /** price currency. */
  @NonNull
  private Currency priceCurrency;



  /**
   * Map from airline offers.
   *
   * @param airlineOffers airline offers
   * @return list
   */
  static List<AirlineOfferModel> mapFromAirlineOffers(List<AirlineOffer> airlineOffers) {
    return airlineOffers.stream().map(AirlineOfferModel::mapFromAirlineOffer)
        .collect(Collectors.toList());
  }

  /**
   * Map from airline offer.
   *
   * @param airlineOffer airline offer
   * @return airline offer model
   */
  private static AirlineOfferModel mapFromAirlineOffer(AirlineOffer airlineOffer) {
    return AirlineOfferModel.builder().from(airlineOffer.getRoute().getFrom())
        .to(airlineOffer.getRoute().getTo()).price(airlineOffer.getPrice().getAmount())
        .priceCurrency(airlineOffer.getPrice().getCurrency()).build();
  }


}
