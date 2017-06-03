/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import java.io.Serializable;

import com.gamma.airlines.common.domain.Authorities.Authority;

import lombok.Builder;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class AuthoritiesId.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Data

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Builder
public class AuthoritiesId implements Serializable {

  /** Constant serialVersionUID. */
  private static final long serialVersionUID = -1703661135470293363L;

  /** authority. */
  private Authorities.Authority authority;

  /** users. */
  private String users;

  /**
   * Instantiates a new authorities id.
   */
  public AuthoritiesId() {

  }

  /**
   * Instantiates a new authorities id.
   *
   * @param authority authority
   * @param users users
   */
  public AuthoritiesId(Authority authority, String users) {
    this.authority = authority;
    this.users = users;
  }



}
