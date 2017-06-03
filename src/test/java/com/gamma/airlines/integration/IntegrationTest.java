/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.integration;

import org.junit.runner.RunWith;

import com.gamma.airlines.BaseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class IntegrationTest.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/buy_tickets.feature")
public class IntegrationTest extends BaseTest {

}
