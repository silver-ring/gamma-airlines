/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.purchasingorders;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.domain.PurchasingOrderRepository;

/**
 * Interface PurchasingOrdersRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface PurchasingOrdersRepository extends PurchasingOrderRepository {

  /**
   * Find all.
   *
   * @return list
   */
  List<PurchasingOrder> findAll();

}
