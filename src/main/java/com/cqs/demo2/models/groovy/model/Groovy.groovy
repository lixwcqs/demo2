package com.cqs.demo2.models.groovy.model

import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.persistence.Transient
import javax.validation.constraints.Size

/**
 * Created by li on 2015/11/30.
 */
@org.hibernate.annotations.Table(appliesTo = "Groovy",comment="Groovy语言对象")
@Table
@Entity()
class Groovy {
//    public static def Hello = "";
    @Id
    @GenericGenerator(name="idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32,nullable = false)
    String id;

    @Temporal(TemporalType.TIMESTAMP)
//    @Column(columnDefinition="DATETIME COMMENT '创建时间'")
    Date createDate;
    @Temporal(TemporalType.DATE)
    Date birthDay;

    float version;

    @Column(columnDefinition="INTEGER COMMENT '用户量'")
    @Size
    int users;

    @Column(length = 100)
    String note;

    @Transient
    String comment;

    void groovyTest(){

    }

}
