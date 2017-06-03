/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.email.purchasingorder;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.domain.PurchasingOrderRepository;

// TODO: Auto-generated Javadoc
/**
 * Interface EmailPurchasingOrderRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface EmailPurchasingOrderRepository extends PurchasingOrderRepository {

  /**
   * Find by id.
   *
   * @param orderId order id
   * @return purchasing order
   */
  PurchasingOrder findById(Long orderId);

}
