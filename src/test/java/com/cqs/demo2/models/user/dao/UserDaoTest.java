package com.cqs.demo2.models.user.dao;

import com.cqs.demo2.models.user.model.User;
import config.BaseTestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTestConfig {

    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Test
    public void testList() throws Exception {

        user.setName("lixw");
        userDao.findAllCriteria(user);
    }
}