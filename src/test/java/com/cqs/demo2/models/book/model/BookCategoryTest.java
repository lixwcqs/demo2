package com.cqs.demo2.models.book.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import static net.mindview.util.Print.print;

/**
 * Created by li on 2016/1/20.
 */
public class BookCategoryTest {

    @Test
    public void testCata() throws Exception {
        for(BookCategory s : BookCategory.values()) {
            print(s + " ordinal: " + s.ordinal());
        }
        System.out.println(ReflectionToStringBuilder.toString(BookCategory.values()));

        System.out.println(BookCategory.valueOf("Photography"));
    }
}