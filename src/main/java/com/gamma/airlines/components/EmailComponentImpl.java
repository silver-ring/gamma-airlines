/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.components;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.gamma.airlines.common.domain.Customer;
import com.gamma.airlines.common.exceptions.SendEmailException;

// TODO: Auto-generated Javadoc
/**
 * Class EmailComponentImpl.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Component
class EmailComponentImpl implements EmailComponent {


  /** mail sender. */
  @Autowired
  private JavaMailSender mailSender;

  /** html template engine. */
  @Autowired
  private SpringTemplateEngine htmlTemplateEngine;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.gamma.airlines.components.EmailComponent#sendEmailToCustomer(com.gamma.airlines.common.
   * domain.Customer, org.springframework.web.servlet.ModelAndView)
   */
  @Override
  public void sendEmailToCustomer(final Customer customer, final ModelAndView modelAndView) {
    try {
      doSendEmail(customer, modelAndView);
    } catch (MessagingException e) {
      throw new SendEmailException();
    }
  }

  /**
   * Do send email.
   *
   * @param customer customer
   * @param modelAndView model and view
   * @throws MessagingException messaging exception
   */
  private void doSendEmail(final Customer customer, final ModelAndView modelAndView)
      throws MessagingException {

    final boolean isMultiPartEmail = true;
    final MimeMessageHelper messageHelper =
        new MimeMessageHelper(mailSender.createMimeMessage(), isMultiPartEmail);
    addEmailInformation(customer, messageHelper);

    final String emailText = getEmailText(modelAndView);
    final boolean isEmailContentHtml = true;
    messageHelper.setText(emailText, isEmailContentHtml);


    mailSender.send(messageHelper.getMimeMessage());

  }

  /**
   * Adds the email information.
   *
   * @param customer customer
   * @param messageHelper message helper
   * @throws MessagingException messaging exception
   */
  private void addEmailInformation(final Customer customer, final MimeMessageHelper messageHelper)
      throws MessagingException {
    final String emailSubject = "Gamma Airlines";
    final String sendedEmail = "postmaster@gammaairlines.com";
    final String reciverEmail = customer.getEmail();

    messageHelper.setSubject(emailSubject);
    messageHelper.setFrom(sendedEmail);
    messageHelper.setTo(reciverEmail);
  }

  /**
   * Gets email text.
   *
   * @param modelAndView model and view
   * @return email text
   */
  private String getEmailText(final ModelAndView modelAndView) {
    final Context temepleContext = getTempleteContext(modelAndView);
    final String resolvedHtml = resolveHtmlTemplete(modelAndView, temepleContext);
    return resolvedHtml;
  }

  /**
   * Resolve html templete.
   *
   * @param modelAndView model and view
   * @param temepleContext temeple context
   * @return string
   */
  private String resolveHtmlTemplete(final ModelAndView modelAndView,
      final Context temepleContext) {
    final String emailTempleteViewName = modelAndView.getViewName();
    return htmlTemplateEngine.process(emailTempleteViewName, temepleContext);
  }

  /**
   * Gets templete context.
   *
   * @param modelAndView model and view
   * @return templete context
   */
  private Context getTempleteContext(final ModelAndView modelAndView) {
    final Context temepleContext = new Context();
    final Map<String, Object> emailTempleteModel = modelAndView.getModel();
    temepleContext.setVariables(emailTempleteModel);
    return temepleContext;
  }

}
