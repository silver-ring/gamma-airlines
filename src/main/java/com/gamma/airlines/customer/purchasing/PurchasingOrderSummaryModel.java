/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingOrderSummaryModel.
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
class PurchasingOrderSummaryModel implements IModel {

  /** order id. */
  @NonNull
  private Long orderId;

  /** full name. */
  @NonNull
  private String fullName;

  /** number of tickets. */
  @NonNull
  private Integer numberOfTickets;

  /** from. */
  @NonNull
  private String from;

  /** to. */
  @NonNull
  private String to;

  /** ticket price. */
  @NonNull
  private Double ticketPrice;

  /** currency. */
  @NonNull
  private Currency currency;

  /** total amount. */
  @NonNull
  private Double totalAmount;

  /**
   * Map from purchasing order.
   *
   * @param purchasingOrder purchasing order
   * @return purchasing order summary model
   */
  static PurchasingOrderSummaryModel mapFromPurchasingOrder(PurchasingOrder purchasingOrder) {
    return PurchasingOrderSummaryModel.builder().orderId(purchasingOrder.getId())
        .fullName(purchasingOrder.getCustomer().getFullName()).from(purchasingOrder.getFromCity())
        .to(purchasingOrder.getToCity()).numberOfTickets(purchasingOrder.getNumberOfTickets())
        .ticketPrice(purchasingOrder.getTicketPrice()).currency(purchasingOrder.getCurrency())
        .totalAmount(purchasingOrder.getTotalAmount()).build();
  }

}
