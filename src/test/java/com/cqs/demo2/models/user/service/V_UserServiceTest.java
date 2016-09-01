package com.cqs.demo2.models.user.service;

import com.cqs.common.utils.Page;
import com.cqs.demo2.models.user.model.V_User;
import config.BaseTestConfig;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by li on 2015/12/2.
 */
public class V_UserServiceTest extends BaseTestConfig{

    @Resource(name = "v_UserService")
    V_UserService service ;
    V_User v_user = new V_User();


    @Test
    public void testList() throws Exception {
        service.list(new Page<>(),v_user);
    }
}