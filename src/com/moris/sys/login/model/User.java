/*******************************************************************************
 * Copyright (c) 2020 Manuel Friedmacher
 *
 * This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * https://github.com/Friedmacher/MoRIS/blob/main/LICENSE
 *
 * Contributors:
 *     Manuel Friedmacher
 *******************************************************************************/
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
