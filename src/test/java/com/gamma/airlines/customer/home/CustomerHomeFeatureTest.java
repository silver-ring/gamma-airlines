/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.home;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class CustomerHomeFeatureTest.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/customer_home.feature")
public class CustomerHomeFeatureTest {

}
