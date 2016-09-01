package com.cqs.common.base;

import com.cqs.common.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;

/**
 * Created by li on 2015/8/21.
 */
@Controller
public class BaseAction_BAK<T> extends ActionSupport
        implements Preparable, ModelDriven, ServletRequestAware, ServletResponseAware {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected T entity;
    protected Class<T> entityClass;

    // 分页参数
    protected Page<T> page = new Page(); // 分页对象

    // 其他参数
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     * 求泛型的类类型
     * @return
     */
    private Class<T> getEntityClass(){
        if(null == entityClass){
            entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }
    /**
     * Gets the model to be pushed onto the ValueStack instead of the Action itself.
     *
     * @return the model
     */
    public Object getModel() {
        return entity;
    }

    /**
     * This method is called to allow the action to prepare itself.
     *
     * @throws Exception thrown if a system level exception occurs.
     */
    public void prepare() throws Exception {
        entity = getEntityClass().newInstance();
    }

    /**
     * Sets the HTTP request object in implementing classes.
     *
     * @param request the HTTP request.
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Sets the HTTP response object in implementing classes.
     *
     * @param response the HTTP response.
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }


    public Page<T> getPage() {
        return page;
    }

    public void setPage(Object page) {
        if (!page.getClass().equals(String.class))
        this.page = (Page<T>) page;
    }
}
