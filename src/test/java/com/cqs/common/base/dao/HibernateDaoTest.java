package com.cqs.common.base.dao;

import config.BaseTestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by li on 2015/9/18.
 */
public class HibernateDaoTest extends BaseTestConfig{
    @Autowired
    private BaseDao baseDao;
    @Test
    public void testGetCurrentSession(){
        System.out.println("==");
    }
}