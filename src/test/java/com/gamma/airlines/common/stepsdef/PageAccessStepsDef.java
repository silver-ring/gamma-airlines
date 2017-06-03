/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.stepsdef;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Map;

import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.UserRequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

// TODO: Auto-generated Javadoc
/**
 * Class PageAccessStepsDef.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
public class PageAccessStepsDef {


  /** mock mvc. */
  private MockMvc mockMvc;

  /** result actions. */
  private ResultActions resultActions;

  /** user request post processor. */
  private UserRequestPostProcessor userRequestPostProcessor;


  /**
   * Instantiates a new page access steps def.
   *
   * @param mockMvc mock mvc
   * @param resultActions result actions
   * @param userRequestPostProcessor user request post processor
   */
  public PageAccessStepsDef(MockMvc mockMvc, ResultActions resultActions,
      UserRequestPostProcessor userRequestPostProcessor) {
    this.mockMvc = mockMvc;
    this.resultActions = resultActions;
    this.userRequestPostProcessor = userRequestPostProcessor;
  }

  /**
   * Try to access page.
   *
   * @param pageUrl page url
   * @throws Throwable throwable
   */
  public void try_to_access_page(String pageUrl) throws Throwable {
    resultActions = mockMvc.perform(get(pageUrl).with(userRequestPostProcessor));
  }

  /**
   * Try to submit to with the following data.
   *
   * @param pageUrl page url
   * @param formParms form parms
   * @throws Throwable throwable
   */
  public void try_to_submit_to_with_the_following_data(String pageUrl,
      Map<String, String> formParms) throws Throwable {
    MultiValueMap<String, String> submitParams = new LinkedMultiValueMap<>();
    submitParams.setAll(formParms);
    resultActions = mockMvc
        .perform(post(pageUrl).params(submitParams).with(userRequestPostProcessor).with(csrf()));
  }

  /**
   * Logged in user with role.
   *
   * @param role role
   * @throws Throwable throwable
   */
  public void logged_in_user_with_role(String role) throws Throwable {
    userRequestPostProcessor = user("test").roles(role);
  }


  /**
   * User should be able to access the page.
   *
   * @throws Throwable throwable
   */
  public void user_should_be_able_to_access_the_page() throws Throwable {
    resultActions.andExpect(status().isOk());
  }

  /**
   * User should be able to access the page with internal server error.
   *
   * @throws Throwable throwable
   */
  public void user_should_be_able_to_access_the_page_with_internal_server_error() throws Throwable {
    resultActions.andExpect(status().isInternalServerError());
  }

  /**
   * User should be able to access the page with bad request.
   *
   * @throws Throwable throwable
   */
  public void user_should_be_able_to_access_the_page_with_bad_request() throws Throwable {
    resultActions.andExpect(status().isBadRequest());
  }

  /**
   * User should be able to access the page with no content.
   *
   * @throws Throwable throwable
   */
  public void user_should_be_able_to_access_the_page_with_no_content() throws Throwable {
    resultActions.andExpect(status().isNoContent());
  }

  /**
   * View should be display.
   *
   * @param view view
   * @throws Throwable throwable
   */
  public void view_should_be_display(String view) throws Throwable {
    resultActions.andExpect(view().name(view));
  }

  /**
   * Should be redirected to.
   *
   * @param url url
   * @throws Throwable throwable
   */
  public void should_be_redirected_to(String url) throws Throwable {
    resultActions.andExpect(redirectedUrl(url));
  }

  /**
   * Url should be found.
   *
   * @throws Throwable throwable
   */
  public void url_should_be_found() throws Throwable {
    resultActions.andExpect(status().isFound());
  }



  /**
   * Model with attribute should be exist with the following values.
   *
   * @param attribute attribute
   * @param values values
   * @throws Throwable throwable
   */
  public void model_with_attribute_should_be_exist_with_the_following_values(String attribute,
      Object values) throws Throwable {
    resultActions.andExpect(model().attribute(attribute, values));
  }

  /**
   * Model should has errors.
   *
   * @param numberOfErrors number of errors
   * @throws Throwable throwable
   */
  public void model_should_has_errors(int numberOfErrors) throws Throwable {
    resultActions.andExpect(model().errorCount(numberOfErrors));
  }


  /**
   * Gets the result actions.
   *
   * @return the result actions
   */
  public ResultActions getResultActions() {
    return resultActions;
  }

  /**
   * Model should have error message.
   *
   * @param message message
   * @throws Throwable throwable
   */
  public void model_should_have_error_message(String message) throws Throwable {
    model_with_attribute_should_be_exist_with_the_following_values("errorMessage", message);
  }

  /**
   * Should be exported in format.
   *
   * @param exportFormat export format
   * @throws Throwable throwable
   */
  public void should_be_exported_in_format(String exportFormat) throws Throwable {
    model_with_attribute_should_be_exist_with_the_following_values("format", exportFormat);
  }



}
