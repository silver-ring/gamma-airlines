/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.export.purchasingorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.PurchasingOrder;

// TODO: Auto-generated Javadoc
/**
 * Class ExportPurchasingOrderService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class ExportPurchasingOrderService implements IService {

  /** purchasing order entity repository. */
  @Autowired
  private ExportPurchasingOrderRepository purchasingOrderEntityRepository;

  /**
   * Find purchasing order.
   *
   * @param purchasingOrderEmailRequest purchasing order email request
   * @return purchasing order pdf model
   */
  public PurchasingOrderPdfModel findPurchasingOrder(
      ExportPurchasingOrderRequest purchasingOrderEmailRequest) {
    PurchasingOrder purchasingOrder =
        purchasingOrderEntityRepository.findById(purchasingOrderEmailRequest.getOrderId());
    return PurchasingOrderPdfModel.mapFromPurchasingOrder(purchasingOrder);
  }



}
