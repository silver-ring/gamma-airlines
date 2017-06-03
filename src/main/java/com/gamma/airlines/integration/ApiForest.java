/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * Interface ApiForest.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@GammaApiClient
public interface ApiForest {

  /**
   * Reset API state.
   */
  @RequestMapping(path = "/reset", method = RequestMethod.GET)
  public void resetAPIState();

}
