/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.purchasing;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class PurchasingFeatureTest.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/customer_purchasing.feature")
public class PurchasingFeatureTest {

}
