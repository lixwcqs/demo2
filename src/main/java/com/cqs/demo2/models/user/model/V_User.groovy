package com.cqs.demo2.models.user.model

import org.hibernate.validator.constraints.Email

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Transient
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


/**
 * Created by li on 2015/12/2.
 */
//@Entity
//@Table(name="V_USER")
public class V_User {
    @Column(length = 60)
    @Size(max = 60,message = "用户名不能超过60")
    @NotNull
    private String name;
    @Column(length = 16)
    @NotNull
    @Size(max = 16)
    private String password;
    @Column(length = 50)
    @Email
    private String email;

//    @SuppressWarnings("unused")
    @Transient
    @Id
    String id;
}
