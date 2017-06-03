/*
 * Cross Over trial project {@link www.crossover.com}
 * 
 */
package com.gamma.airlines.integration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Interface GammaApiClient.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FeignClient(name = "ZlAdOEQ", url = "https://api-forest.crossover.com/ZlAdOEQ")
public @interface GammaApiClient {

}
