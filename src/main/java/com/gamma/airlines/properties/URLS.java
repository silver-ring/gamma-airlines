/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.properties;

import static com.gamma.airlines.properties.RolesProperties.ADMIN_ROOT_URL;
import static com.gamma.airlines.properties.RolesProperties.ANONYMOUS_ROOT_URL;
import static com.gamma.airlines.properties.RolesProperties.CUSTOMER_ROOT_URL;


// TODO: Auto-generated Javadoc
/**
 * Class URLS.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
final public class URLS {


  /** Constant LOGIN. */
  // login
  public static final String LOGIN = ANONYMOUS_ROOT_URL;

  /** Constant LOGIN_ERROR. */
  public static final String LOGIN_ERROR = LOGIN + "?error=true";

  /** Constant Home. */
  public static final String Home = LOGIN + "home";

  /** Constant REGISTRATION. */
  // registration
  public static final String REGISTRATION = ANONYMOUS_ROOT_URL + "registration";

  /** Constant ADMIN_HOME. */
  // admin pages
  public static final String ADMIN_HOME = ADMIN_ROOT_URL + "home";

  /** Constant ADMIN_CUSTOMERS. */
  public static final String ADMIN_CUSTOMERS = ADMIN_ROOT_URL + "customers";

  /** Constant ADMIN_PURCHASING_ORDERS. */
  public static final String ADMIN_PURCHASING_ORDERS = ADMIN_ROOT_URL + "orders";

  /** Constant CUSTOMER_HOME. */
  // customer pages
  public static final String CUSTOMER_HOME = CUSTOMER_ROOT_URL + "home";

  /** Constant CUSTOMER_PURCHASE_ORDER_DETAILS. */
  public static final String CUSTOMER_PURCHASE_ORDER_DETAILS =
      CUSTOMER_ROOT_URL + "purchase/{from}/{to}";

  /** Constant CUSTOMER_PURCHASE_TICKET. */
  public static final String CUSTOMER_PURCHASE_TICKET = CUSTOMER_ROOT_URL + "purchase/{from}/{to}";

  /** Constant CUSTOMER_MY_TICKETS. */
  public static final String CUSTOMER_MY_TICKETS = CUSTOMER_ROOT_URL + "mytickets";

  /** Constant CUSTOMER_EMAIL_PURCHASING_ORDER. */
  public static final String CUSTOMER_EMAIL_PURCHASING_ORDER =
      CUSTOMER_ROOT_URL + "purchase/email/{orderId}";

  /** Constant CUSTOMER_EXPORT_PURCHASING_ORDER_PDF. */
  public static final String CUSTOMER_EXPORT_PURCHASING_ORDER_PDF =
      CUSTOMER_ROOT_URL + "purchase/export/pdf/{orderId}";



}
