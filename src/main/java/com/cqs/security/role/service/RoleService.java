package com.cqs.security.role.service;

import com.cqs.common.base.BaseService;
import com.cqs.security.role.dao.RoleDao;
import com.cqs.security.role.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by li on 2016/1/8.
 */
@Service
@Transactional
public class RoleService extends BaseService<Role,String> {
    @Resource
    private RoleDao roleDao;
}
