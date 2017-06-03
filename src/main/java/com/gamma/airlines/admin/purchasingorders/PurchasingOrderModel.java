/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.purchasingorders;

import java.util.List;
import java.util.stream.Collectors;

import com.gamma.airlines.common.IModel;
import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.enums.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


/**
 * Class PurchasingOrderModel.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */

@Data
@Builder
class PurchasingOrderModel implements IModel {

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
   * @param purchsingOrders purchsing orders
   * @return list
   */
  static List<PurchasingOrderModel> mapFromPurchasingOrders(List<PurchasingOrder> purchsingOrders) {
    return purchsingOrders.stream().map(PurchasingOrderModel::mapFromPurchasingOrder)
        .collect(Collectors.toList());
  }

  /**
   * Map from purchasing order.
   *
   * @param purchsingOrder purchsing order
   * @return purchasing order model
   */
  private static PurchasingOrderModel mapFromPurchasingOrder(PurchasingOrder purchsingOrder) {
    return PurchasingOrderModel.builder().orderId(purchsingOrder.getId())
        .from(purchsingOrder.getFromCity()).to(purchsingOrder.getToCity())
        .numberOfTickets(purchsingOrder.getNumberOfTickets())
        .ticketPrice(purchsingOrder.getTicketPrice()).priceCurrency(purchsingOrder.getCurrency())
        .totalAmount(purchsingOrder.getTotalAmount()).build();
  }

}
