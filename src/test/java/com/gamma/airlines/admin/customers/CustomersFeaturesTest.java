/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.admin.customers;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class CustomersFeaturesTest.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/admin_customers.feature")
public class CustomersFeaturesTest {

}
