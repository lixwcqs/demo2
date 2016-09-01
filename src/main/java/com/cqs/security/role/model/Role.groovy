package com.cqs.security.role.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

/**
 * Created by li on 2016/1/8.
 */
@Entity
@Table
class Role {
    @Id
    @GenericGenerator(name="idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32,nullable = false)
    String id;
    @Column(length = 30,nullable = false)
    String name;

//    @Fetch(FetchMode.SUBSELECT)
//    @JoinColumn
//    @ElementCollection(fetch = FetchType.EAGER)
//    Set<String> authorities;
}
