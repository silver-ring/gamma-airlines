/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.email.purchasingorder;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * Class PurchasingOrderEmailModel.
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
class PurchasingOrderEmailModel implements IModel {

  /** email. */
  @NonNull
  private String email;

  /** full name. */
  @NonNull
  private String fullName;

  /** order id. */
  @NonNull
  private Long orderId;

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

  /** number of tickets. */
  @NonNull
  private Integer numberOfTickets;

  /** total amount. */
  @NonNull
  private Double totalAmount;


  /**
   * Map from purchasing order.
   *
   * @param purchasingOrder purchasing order
   * @return purchasing order email model
   */
  static PurchasingOrderEmailModel mapFromPurchasingOrder(PurchasingOrder purchasingOrder) {
    return PurchasingOrderEmailModel.builder().email(purchasingOrder.getCustomer().getEmail())
        .fullName(purchasingOrder.getCustomer().getFullName()).orderId(purchasingOrder.getId())
        .from(purchasingOrder.getFromCity()).to(purchasingOrder.getToCity())
        .ticketPrice(purchasingOrder.getTicketPrice()).currency(purchasingOrder.getCurrency())
        .numberOfTickets(purchasingOrder.getNumberOfTickets())
        .totalAmount(purchasingOrder.getTotalAmount()).build();
  }


}
