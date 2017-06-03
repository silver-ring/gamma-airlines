/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

// TODO: Auto-generated Javadoc
/**
 * Class WebMvcConfig.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Configuration
public class WebMvcConfig {

  /**
   * Gets jasper reports view resolver.
   *
   * @return jasper reports view resolver
   */
  @Bean
  public JasperReportsViewResolver getJasperReportsViewResolver() {

    JasperReportsViewResolver resolver = new JasperReportsViewResolver();
    resolver.setPrefix("classpath:templates/");
    resolver.setSuffix(".jrxml");
    resolver.setViewNames("*pdf");
    resolver.setReportDataKey("datasource");
    resolver.setViewClass(JasperReportsMultiFormatView.class);
    resolver.setOrder(0);
    return resolver;
  }

}
