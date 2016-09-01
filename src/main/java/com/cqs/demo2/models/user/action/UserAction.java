package com.cqs.demo2.models.user.action;

import com.alibaba.fastjson.JSON;
import com.cqs.common.base.BaseAction;
import com.cqs.common.utils.Page;
import com.cqs.demo2.models.user.model.User;
import com.cqs.demo2.models.user.service.UserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Date;

//import net.sf.json.JSONArray;

/**
 * Created by li on 2015/8/21.
 */
@Controller
public class UserAction extends BaseAction<User> {

    @Autowired
    private UserService userService;

//    @Resource
//    private AuthenticationManager authenticationManager;

    public String create() {
        logger.debug(request.getCharacterEncoding());
        logger.debug("新建用户");
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
//        entity.setName("新用户");
        userService.create(entity);
        return SUCCESS;
    }

    public String delete() {
        String id = request.getParameter("id");
        logger.debug("删除用户");
        userService.delete(id);
        return SUCCESS;
    }

    public String updateUser() {
        logger.debug("更新实体{}",entity);
        entity.setUpdateDate(new Date());
        userService.update(entity);
        return SUCCESS;
    }

    public String login() {
//        String username = request.getParameter("j_username");
//        String password = request.getParameter("j_password");
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        HttpServletRequest request = ServletActionContext.getRequest();
//        // generate session if one doesn't exist
//        request.getSession();
//
//        token.setDetails(new WebAuthenticationDetails(request));
//        Authentication authenticatedUser = null;
//        try {
//            authenticatedUser = authenticationManager.authenticate(token);
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        return SUCCESS;
    }

    public String list() {
        logger.debug(request.getParameter("ch"));
        jqpage.setPageNo(request.getParameter("page"));
        userService.listPage(jqpage, entity);
        request.setAttribute("page", jqpage);
        logger.debug("页数：" + jqpage.getPages());
        return SUCCESS;
    }

    public String listJSON() {
        logger.debug(ReflectionToStringBuilder.toString(request));
        HttpSession session = request.getSession();
        logger.debug(ReflectionToStringBuilder.toString(session.getAttributeNames()));
        jqpage.setPageNo(request.getParameter("page"));
        userService.listPage(jqpage, entity);
        users = JSON.toJSONString(jqpage.getResult());
        logger.debug("页数：" + jqpage.getPages());
        request.setAttribute("user",entity);
        return SUCCESS;
    }


    public String list2(){
        logger.debug("用户列表查询");
        Page<User> tpage = userService.listPage(jqpage, entity);
        jsonResult.put("users", tpage.getResult());
        jsonResult.put("jqpage", tpage);
        return SUCCESS;
    }

    private String users = new String();

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}