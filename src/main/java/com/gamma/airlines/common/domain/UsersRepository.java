/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import com.gamma.airlines.common.IRepository;

/**
 * Interface UsersRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 * @param <T> generic type
 */
public interface UsersRepository<T extends Users> extends IRepository<T, String> {

}
