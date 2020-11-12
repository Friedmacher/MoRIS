/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */
package com.moris.sys.login.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="mdt_user", schema="moris")
public class User {
    
    @Id
    private String userName;
    
    private String password;
    private Date lastLogin;
    private Date lastPasswordChange;
    private Boolean active;
    private Boolean locked;
    private Boolean passwordChange;

    public User() {}
    
}
