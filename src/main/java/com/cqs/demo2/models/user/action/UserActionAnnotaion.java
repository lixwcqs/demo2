package com.cqs.demo2.models.user.action;

import com.cqs.common.base.BaseAction;
import com.cqs.demo2.models.user.model.User;
import com.cqs.demo2.models.user.service.UserService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by li on 2015/8/21.
 */
//保证Spring可以找得到
@Component
//@ParentPackage("struts-default")
//json-default继承struts-default
@ParentPackage("json-default")
//命名空间 影响的.action的URL【毕竟这里只是注释一个Action】，不影响JSP等资源
@Namespace("/user1")
//异常处理
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
public class UserActionAnnotaion extends BaseAction<User> {

    @Autowired
    private UserService userService;


    private User user = new User() ;

    private ArrayList users = new ArrayList();

    public ArrayList getUsers() {
        return users;
    }

    public void setUsers(ArrayList users) {
        this.users = users;
    }

    /**
     *
     * @Result的location ‘/’ 表示相对项目的相对路径，及/webapp
     * 注意@Result中type="chain"和type = "redirectAction"区别：
     * chain，相当是一次请求，所以实体的信心全部会带list的方法中去
     * redirectAction实体的信息全部丢失，相当于一次新的请求
     */
    @Action(value = "create", results = { @Result(name = "success", type = "redirectAction" ,location = "list") })
    public String create() {
        logger.debug("新建用户。。");
        entity.setPassword("123");
        entity.setEmail("li@163.com");
        entity.setName("新用户");
        userService.create(entity);
        return SUCCESS;
    }

//    @Action(value = "update", results = {
//            @Result(name = SUCCESS,  location = "/demo2/user/user_list.jsp")
//    })
//    public String updateUser() {
//        entity.setId("40283a814f7d92f7014f7d956bf50007");
//        entity.setName("互联网");
//        entity.setPassword(String.valueOf((int) (Math.random() * 1000)));
//        entity.setEmail("cqs@163.com");
//        userService.update(entity);
//        return SUCCESS;
//    }


        @Action(value = "listUsers",results = {
            @Result(name = "success",location = "user_list.jsp"),
            @Result(name = "error", location = "/demo2/commons/404.jsp")
    })
    public String list() {
        jqpage.setPageNo(request.getParameter("pageNo"));
//        if(page.getPageNo() == 2){
//            logger.debug("Hello Test");
//            return ERROR;
//        }
//        if(page.getPageNo() == 3){
////            throw new RuntimeException("出错了，同学");
//        }
//        JqPage jpage =
        userService.listPage(jqpage, entity);
        request.setAttribute("page", jqpage);
        logger.debug("页数：" + jqpage.getPages());
        return SUCCESS;
    }


    @Action(value = "list", results = {
//            @Result(name = SUCCESS, type = "json",location = "/demo2/user/list.jsp")
            @Result( type = "json",params = {
                    "users","${users}"
            })
    })
    public String listJSON() {
        jqpage.setPageNo(request.getParameter("pageNo"));
        userService.listPage(jqpage, entity);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
        logger.debug("页数：" + jqpage.getPages());
        return SUCCESS;
    }

}