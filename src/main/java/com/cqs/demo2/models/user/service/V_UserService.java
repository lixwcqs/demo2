package com.cqs.demo2.models.user.service;

import com.cqs.common.base.BaseService;
import com.cqs.demo2.models.user.dao.V_UserDao;
import com.cqs.demo2.models.user.model.V_User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by li on 2015/12/2.
 */
@Transactional
@Service
public class V_UserService extends BaseService<V_User,String> {

    @Resource
    private V_UserDao v_userDao;
}
