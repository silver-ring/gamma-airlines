/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class AppConfig.
 * 
 * this class has the main spring boot configuration to be loaded
 * 
 *
 * @author Mohamed Morsy
 * @version 1.0
 * 
 * @see SpringBootApplication
 * 
 */
@SpringBootApplication
public class AppConfig {

  /**
   * The main method.
   *
   * @param args arguments for the main function
   */
  public static void main(String[] args) {
    SpringApplication.run(AppConfig.class, args);
  }

}
