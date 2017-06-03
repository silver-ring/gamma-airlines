/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.common;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Interface IRepository.
 *
 * @author Mohamed Morsy
 * @version 1.0
 * @param <T> generic type
 * @param <ID> generic type
 */
@NoRepositoryBean
public interface IRepository<T, ID extends Serializable> extends Repository<T, ID> {

}
