package com.cqs.demo2.models.news.action;

import com.opensymphony.xwork2.ActionProxy;
import config.TestConfig;
import junit.framework.TestCase;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by li on 2016/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//不能加载.properties文件，否则报错
@ContextConfiguration({"classpath:applicationContext.xml"})
//public class NewsActionTest extends StrutsJUnit4TestCase<NewsAction> implements TestConfig{
public class NewsActionTest extends StrutsSpringJUnit4TestCase{
//public class NewsActionTest extends StrutsSpringJUnit4TestCase<NewsAction> implements TestConfig{


    @Test
    public void testOneStrutsAction() throws Exception {
//        ActionProxy actionProxy = getActionProxy("/news/list.action");
        ActionProxy actionProxy = getActionProxy("/user/list.action");
        Map<String, Object> sessionMap = new HashMap<String, Object>();
        actionProxy.getInvocation().getInvocationContext().setSession(sessionMap);
        actionProxy.execute();

    }

    @Test
    public void testList() throws Exception {

    }

    @Test
    public void testGetNews() throws Exception {

    }
}