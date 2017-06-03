/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.purchasingorders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.airlines.common.IService;
import com.gamma.airlines.common.domain.PurchasingOrder;


/**
 * Class PurchasingOrdersService.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Service
class PurchasingOrdersService implements IService {

  /** purchasing order entity repository. */
  @Autowired
  private PurchasingOrdersRepository purchasingOrderEntityRepository;

  /**
   * Find all purchasing orders.
   *
   * @return list
   */
  List<PurchasingOrderModel> findAllPurchasingOrders() {
    List<PurchasingOrder> purchsingOrders = purchasingOrderEntityRepository.findAll();
    return PurchasingOrderModel.mapFromPurchasingOrders(purchsingOrders);
  }



}
