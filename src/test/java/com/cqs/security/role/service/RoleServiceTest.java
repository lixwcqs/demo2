package com.cqs.security.role.service;

import com.cqs.security.role.model.Role;
import config.BaseTestConfig;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by li on 2016/1/8.
 */
public class RoleServiceTest extends BaseTestConfig{

    @Resource
    RoleService service;

    Role role = new Role();

    void initRole(){
        role.setName("超级管理员");
    }


    @Test
    public void testCreate() throws Exception {
        initRole();
        service.create(role);
    }
}