package com.cqs.common.base;

import com.cqs.common.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2015/8/21.
 */
@Controller
public class BaseAction<T> extends ActionSupport
        implements Preparable, ModelDriven, ServletRequestAware, ServletResponseAware {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    //往前台传JSON格式数据
    protected Map<String,Object> jsonResult = new HashMap<String, Object>();

    protected T entity;
    protected Class<T> entityClass;

    // 分页参数
    protected Page<T> jqpage = new Page(); // 分页对象


    // 其他参数
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public BaseAction() {
//        ModelDrivenInterceptor modelDrivenInterceptor;
//        logger.debug("baseAction初始化");
//        initJqpage();
    }

    /**
     * Jqgrid插件每次提交表单的时候均会自动提交page,rows等参数
     * 这些参数必须和后台的分页插件数据相对应，要不能就获取不到相应的数据
     */
    protected void initJqpage() {
        //当前页码
        jqpage.setPageNo(request.getParameter("page"));
        //每页展示的记录数，对应jqgrid的rownum/rowList
        jqpage.setPageSize(request.getParameter("rows"));
    }
    protected void initJqpage1(){
        //若使用Jqgrid插件的话，提交表单的时候，会自动在URL添加参数page，rows等参数
        //当前页码
        String page = request.getParameter("page");
        //GET方式提交
        if(StringUtils.isNotEmpty(page)){
            jqpage.setPageNo(page);
        }else{//POST方式提交
            jqpage.setPageNo((Integer)request.getAttribute("page"));
        }

        //每页展示的记录数，对应jqgrid的rownum/rowList
        //GET方式提交
        String rows = request.getParameter("rows");
        if(StringUtils.isNotEmpty(rows)){
            jqpage.setPageSize(rows);
        }else{//POST方式提交
            jqpage.setPageSize((Integer)request.getAttribute("rows"));
        }
    }

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
        initJqpage();
    }

    /**
     * Sets the HTTP response object in implementing classes.
     *
     * @param response the HTTP response.
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Page<T> getJqpage() {
        return jqpage;
    }

    public void setJqpage(Page<T> jqpage) {
        this.jqpage = jqpage;
    }


    public Map<String, Object> getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(Map<String, Object> jsonResult) {
        this.jsonResult = jsonResult;
    }
}
