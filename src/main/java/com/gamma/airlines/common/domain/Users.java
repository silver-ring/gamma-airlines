/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.gamma.airlines.common.IBaseEntity;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Class Users.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

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
public abstract class Users implements IBaseEntity {

  /** username. */
  @Id
  private String username;

  /** password. */
  @Column(nullable = false)
  private String password;

  /** enabled. */
  @Column(nullable = false)
  private Boolean enabled;

  /** authoritieses. */
  @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "users")
  private List<Authorities> authoritieses = new ArrayList<>();

  /**
   * Instantiates a new users.
   */
  public Users() {}

  /**
   * Instantiates a new users.
   *
   * @param username username
   * @param password password
   * @param enabled enabled
   */
  public Users(String username, String password, Boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

}
