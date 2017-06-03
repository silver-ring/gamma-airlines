/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gamma.airlines.common.IBaseEntity;

import lombok.Builder;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class Authorities.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Entity
@IdClass(AuthoritiesId.class)

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
public class Authorities implements IBaseEntity {

  /** authority. */
  @Id
  @Enumerated(EnumType.STRING)
  private Authority authority;

  /** users. */
  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "username")
  private Users users;

  /**
   * Instantiates a new authorities.
   */
  public Authorities() {}



  /**
   * Instantiates a new authorities.
   *
   * @param authority authority
   * @param users users
   */
  public Authorities(Authority authority, Users users) {
    this.authority = authority;
    this.users = users;
  }

  /**
   * Enum Authority.
   *
   * @author Mohamed Morsy
   * @version 1.0
   */
  public enum Authority {

    /** role customer. */
    ROLE_CUSTOMER,

    /** role admin. */
    ROLE_ADMIN
  }

}
