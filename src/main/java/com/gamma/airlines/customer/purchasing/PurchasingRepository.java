/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.domain.PurchasingOrderRepository;

// TODO: Auto-generated Javadoc
/**
 * Interface PurchasingRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface PurchasingRepository extends PurchasingOrderRepository {

  /**
   * Save.
   *
   * @param purchasingOrder purchasing order
   * @return purchasing order
   */
  PurchasingOrder save(PurchasingOrder purchasingOrder);

}
