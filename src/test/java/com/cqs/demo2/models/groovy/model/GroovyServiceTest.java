package com.cqs.demo2.models.groovy.model;

import com.cqs.demo2.models.groovy.service.GroovyService;
import config.BaseTestConfig;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by li on 2015/11/30.
 */
public class GroovyServiceTest extends BaseTestConfig{

    @Resource
    GroovyService service;

//    @Resource
//    UserService userService;

    private Groovy groovy = new Groovy();

    public void initGroovy() {
        groovy.setCreateDate(new Date());
        Date date  = null;
        try {
           date =  DateUtils.parseDate("2009-10-20","yyyy-MM-dd");
           System.out.println("Date: " + ReflectionToStringBuilder.toString(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        groovy.setBirthDay(date);
        groovy.setNote("Groovy是面向21世纪的Java语言");
        groovy.setComment("现在用户量不多啊");
        groovy.setUsers((int) (Math.random()*10000));
        groovy.setVersion(2.45f);

    }

    @Test
    public void testCreate() throws Exception {
        initGroovy();
        service.create(groovy);
    }
}