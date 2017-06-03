/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.export.purchasingorder;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.PurchasingOrder;
import com.gamma.airlines.common.domain.PurchasingOrderRepository;


// TODO: Auto-generated Javadoc
/**
 * Interface ExportPurchasingOrderRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface ExportPurchasingOrderRepository extends PurchasingOrderRepository {

  /**
   * Find by id.
   *
   * @param orderId order id
   * @return purchasing order
   */
  PurchasingOrder findById(Long orderId);

}
