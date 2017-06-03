/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.Overloaded;
import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.exceptions.InsufficientFundsException;
import com.gamma.airlines.common.exceptions.OfferNotFoundException;
import com.gamma.airlines.components.UsersComponent;
import com.gamma.airlines.integration.GammaAirlines;
import com.gamma.airlines.integration.json.AirlineOffer;
import com.gamma.airlines.integration.json.AirlineRoute;
import com.gamma.airlines.integration.json.AirlineTicket;
import com.gamma.airlines.integration.json.BuyTicketsRequest;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class PurchasingService implements IService {

  /** users component. */
  @Autowired
  private UsersComponent usersComponent;

  /** gamma airlines. */
  @Autowired
  private GammaAirlines gammaAirlines;

  /** purchasing order entity repository. */
  @Autowired
  private PurchasingRepository purchasingOrderEntityRepository;

  /**
   * Gets purchasing details.
   *
   * @param purchaseRequest purchase request
   * @return purchasing details
   */
  PurchasingDetailsModel getPurchasingDetails(PurchaseRequest purchaseRequest) {
    AirlineOffer airlineOffer = fetchAirlineOffer(purchaseRequest);
    Customer customer = getLoggedInCustomer();
    return PurchasingDetailsModel.mapFromAirlineOffer(airlineOffer, customer);
  }

  /**
   * Buy ticket.
   *
   * @param purchasingForm purchasing form
   * @return purchasing order summary model
   */
  PurchasingOrderSummaryModel buyTicket(PurchasingForm purchasingForm) {
    AirlineOffer airlineOffer = fetchAirlineOffer(purchasingForm);
    AirlineTicket airlineTicket = orderTicket(purchasingForm.getNumberOfTickets(), airlineOffer);
    PurchasingOrder purchasingOrder = saveTicketPurchasingOrder(airlineTicket);
    return PurchasingOrderSummaryModel.mapFromPurchasingOrder(purchasingOrder);
  }

  /**
   * Fetch airline offer.
   *
   * @param purchaseRequest purchase request
   * @return airline offer
   */
  @Overloaded
  private AirlineOffer fetchAirlineOffer(PurchaseRequest purchaseRequest) {
    return fetchAirlineOffer(purchaseRequest.getFrom(), purchaseRequest.getTo());
  }

  /**
   * Fetch airline offer.
   *
   * @param purchaseForm purchase form
   * @return airline offer
   */
  @Overloaded
  private AirlineOffer fetchAirlineOffer(PurchasingForm purchaseForm) {
    return fetchAirlineOffer(purchaseForm.getFrom(), purchaseForm.getTo());
  }

  /**
   * Fetch airline offer.
   *
   * @param fromCite from cite
   * @param toCite to cite
   * @return airline offer
   */
  @Overloaded
  private AirlineOffer fetchAirlineOffer(String fromCite, String toCite) {
    return gammaAirlines.listAllOffers().stream()
        .filter(offer -> offer.getRoute().getFrom().contains(fromCite)
            && offer.getRoute().getTo().contains(toCite))
        .findAny().orElseThrow(() -> new OfferNotFoundException());
  }

  /**
   * Order ticket.
   *
   * @param numberOfTickets number of tickets
   * @param airlineOffer airline offer
   * @return airline ticket
   */
  private AirlineTicket orderTicket(Integer numberOfTickets, AirlineOffer airlineOffer) {
    Customer customer = getLoggedInCustomer();
    BuyTicketsRequest buyTicketsRequest = BuyTicketsRequest.builder()
        .accountId(customer.getPaypalletsAccountId())
        .amount(numberOfTickets).route(AirlineRoute.builder()
            .from(airlineOffer.getRoute().getFrom()).to(airlineOffer.getRoute().getTo()).build())
        .build();
    try {
      return gammaAirlines.buyTicket(buyTicketsRequest);
    } catch (Exception ex) {
      throw new InsufficientFundsException();
    }

  }

  /**
   * Save ticket purchasing order.
   *
   * @param airlineTicket airline ticket
   * @return purchasing order
   */
  private PurchasingOrder saveTicketPurchasingOrder(AirlineTicket airlineTicket) {
    Customer customer = getLoggedInCustomer();
    PurchasingOrder purchasingOrder =
        PurchasingOrderMapper.mapFromAirlineTicket(airlineTicket, customer);
    return purchasingOrderEntityRepository.save(purchasingOrder);
  }



  /**
   * Gets logged in customer.
   *
   * @return logged in customer
   */
  private Customer getLoggedInCustomer() {
    return usersComponent.getLoggedInCustomer();
  }


}
