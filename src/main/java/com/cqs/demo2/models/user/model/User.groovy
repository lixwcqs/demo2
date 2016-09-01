package com.cqs.demo2.models.user.model

import com.cqs.security.role.model.Role
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Email

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by li on 2016/1/12.
 */
@Entity
@Table
class User {
    @Id
    @GenericGenerator(name="idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32)
    String id;

    @Column(length = 60)
    @Size(max = 60,message = "用户名不能超过60")
    @NotNull
    String name;


    @Column(length = 16)
    @NotNull
    @Size(max = 16)
    String password;



    @Column(length = 50)
    @Email
    String email;


    @Column(length = 10)
    String status;



    public String toString(){
        return "用户名： " + getName() +" 主键： " + getId();
    }


    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;


    @Temporal(TemporalType.TIMESTAMP)
    Date updateDate;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.SAVE_UPDATE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles ;

//     @Fetch(FetchMode.SUBSELECT)
//    @OneToMany(fetch = FetchType.EAGER)
//    @Cascade(value = CascadeType.SAVE_UPDATE)
//    @JoinColumn(name = "user_id")//表示外键在ImageUpload表中

}
