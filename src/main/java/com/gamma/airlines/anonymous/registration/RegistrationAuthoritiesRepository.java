/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.anonymous.registration;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.domain.Authorities;
import com.gamma.airlines.common.domain.AuthoritiesRepository;

// TODO: Auto-generated Javadoc
/**
 * Interface RegistrationAuthoritiesRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
interface RegistrationAuthoritiesRepository extends AuthoritiesRepository {

  /**
   * Save.
   *
   * @param authorities authorities
   */
  void save(Authorities authorities);

}
