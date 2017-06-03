/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import org.springframework.stereotype.Repository;

import com.gamma.airlines.common.IRepository;

/**
 * Interface AuthoritiesRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Repository
public interface AuthoritiesRepository extends IRepository<Authorities, AuthoritiesId> {

}
