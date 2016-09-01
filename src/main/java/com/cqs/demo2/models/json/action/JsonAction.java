package com.cqs.demo2.models.json.action;

import com.cqs.common.base.BaseAction;
import com.cqs.demo2.models.user.model.User;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2015/9/4.
 */
//@Component
//@ParentPackage("json-default")
//@Namespace("/jsn")
@Controller
public class JsonAction extends BaseAction<User> {

//    @Action(value = "jsn" , results = {
//            @Result(type = "json",params = {
//                    "root","${msg}"
//            })
//    })
    public String json() {
        msg = new HashMap<String, Object>();
        msg.put("flag", "success");

        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "张三");
        user.put("age", "34");
        msg.put("user", user);
        logger.debug("FUNK YOU");
        return SUCCESS;
    }

//    @Action(value = "hi", results = {
//            @Result( location = "/demo2/user/user_list.jsp")
//    })
    public String say(){
        logger.debug("hi");
        return SUCCESS;
    }

    //==================================
    private Map<String, Object> msg;

    public Map<String, Object> getMsg() {
        return msg;
    }

}
