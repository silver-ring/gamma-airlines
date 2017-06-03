/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.mytickets;

import java.util.List;
import java.util.stream.Collectors;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


// TODO: Auto-generated Javadoc
/**
 * Class OrderModel.
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
class OrderModel implements IModel {

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

  /** price currency. */
  @NonNull
  private Currency priceCurrency;

  /** number of tickets. */
  @NonNull
  private Integer numberOfTickets;

  /** total amount. */
  @NonNull
  private Double totalAmount;


  /**
   * Map from purchasing orders.
   *
   * @param purchasingOrders purchasing orders
   * @return list
   */
  static List<OrderModel> mapFromPurchasingOrders(List<PurchasingOrder> purchasingOrders) {
    return purchasingOrders.stream().map(OrderModel::mapFromPurchasingOrder)
        .collect(Collectors.toList());
  }


  /**
   * Map from purchasing order.
   *
   * @param purchasingOrder purchasing order
   * @return order model
   */
  private static OrderModel mapFromPurchasingOrder(PurchasingOrder purchasingOrder) {
    return OrderModel.builder().orderId(purchasingOrder.getId()).from(purchasingOrder.getFromCity())
        .to(purchasingOrder.getToCity()).ticketPrice(purchasingOrder.getTicketPrice())
        .priceCurrency(purchasingOrder.getCurrency())
        .numberOfTickets(purchasingOrder.getNumberOfTickets())
        .totalAmount(purchasingOrder.getTotalAmount()).build();
  }

}
