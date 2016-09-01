package com.cqs.demo2.models.book.model
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length

import javax.persistence.*
/**
 * Created by li on 2016/1/20.
 */
@Entity
@Table
class Book {
    @Id
    @GenericGenerator(name="idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
//    @Column(length = 32)
    @Length(min = 32,max = 32)
    String id ;

    @Column(columnDefinition = "decimal(5,2)")
//    @Digits(fraction = 2, integer = 5) //限制5位int数字,小数部分为2位.
    double price;//定价

    @Column(columnDefinition = "decimal(5,2)")
    double selling;//售价

    @Column(columnDefinition = "decimal(3,2)")
//    @Size(min = 0, max = 1)
//    @NotNull
    double discount = 1;//折扣
    @Column(length = 40)
    String name;
    //    @Column(length = 30)
    @Length(min=2,max=30)//检查所属的字段的长度是否在min和max之间,只能用于字符串
    String author;//作者
    @Column(length = 40)
    String publisher;//出版社
    @Temporal(TemporalType.DATE)
    Date publishDate;//出版日期

    boolean isActive;//是否在售

//    @Min(value = 0)
//    @Max(value = 10000)
    int storge;//库存

    @Column
    BookCategory category;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    Date createDate;
    Date updateDate;

}
