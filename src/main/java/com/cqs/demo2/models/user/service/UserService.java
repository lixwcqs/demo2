package com.cqs.demo2.models.user.service;

import com.alibaba.fastjson.JSONArray;
import com.cqs.common.base.BaseService;
import com.cqs.common.utils.Page;
import com.cqs.demo2.models.user.dao.UserDao;
import com.cqs.demo2.models.user.model.User;
//import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by li on 2015/8/21.
 */
@Service
@Transactional
public class UserService extends BaseService<User,String>{

    @Autowired
    private UserDao userDao;

    @Deprecated
    public String log4J(){
        logger.debug("NMA");
        return "Hello World";
    }

//    public JSONArray listJSON(User user){
//        return  JSONArray.fromObject(finaAll(user));
//    }
    public String listJSON(User user){
        return  JSONArray.toJSONString(finaAll(user));
    }

    public List<User> list(Page<User> page, User user){
        return userDao.list(page, user);
    }

    public List<User> getUserByName(String username){
        return userDao.getUserByName(username);
    }
}
