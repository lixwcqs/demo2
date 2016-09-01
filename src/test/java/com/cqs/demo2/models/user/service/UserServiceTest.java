package com.cqs.demo2.models.user.service;

import com.cqs.demo2.models.user.model.User;
import com.cqs.security.role.model.Role;
import config.BaseTestConfig;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class UserServiceTest extends BaseTestConfig {


    @Resource
    private UserService userService;
//    @InjectMocks
    private UserService mockService;

    private User user = new User();


    private List<Role> roles = new ArrayList<>();

    String[] usersName = {
        "admin","customer","dba"
    };


   void initRoles(int i){
        Role role = new Role();
        role.setName(usersName[i]);
        roles.add(role);

    }

    public void initUser(int num){
        roles.clear();
       user.setName(usersName[num].toLowerCase());
        user.setEmail("fhdjkasj@163.com");
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setPassword("1");
        user.setStatus(Math.random() > 0.5 ? "active" : "inactive");
        initRoles(num);
        user.setRoles(roles);
    }

    @Test
    public void testList2(){
        String id = "40283a814f7d92f7014f7d956bf50007";
        userService.get(id);
    }

    @Test
    public void testCreate() throws Exception {
//        user.setPassword("1234");
        //Spring会自动回滚，不会写入到数据库中。经有篇博客说，Spring只是在session层写入，
        // 不会持久化到数据库中，这也比较贴近测试原则
        for (int i = 0; i < usersName.length; i++) {
            initUser(i);
            userService.create(user);
        }
//        assertEquals();
//           userService.create();
    }

    @Test
    public void testCreateMock() throws Exception {
        user.setName("cqs+");
        user.setPassword("1234");
        //Spring会自动回滚，不会写入到数据库中。经有篇博客说，Spring只是在session层写入，
        // 不会持久化到数据库中，这也比较贴近测试原则
//        userService.create(user);
//        mockService.create(user);
//        assertEquals();
//           userService.create();
    }

    @Test
    public void testUpdate() throws Exception {
        user.setId("40283a814f7a188c014f7a188e260000");
        user.setName("lixw");
        user.setPassword("12345");
        //也不会持久化到数据库，
        userService.update(user);
    }

    @Test
    public void testUpdate2() throws Exception {
        user.setId("40283a814f7a188c014f7a188e260000");
        user.setName("lixw");
        user.setPassword("12");
        //也不会持久化到数据库，
        userService.update(user);
    }

    @Test
    public  void test1(){
        Comparable c=mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
    }

    @Test
    public  void test2(){
        UserService mock = mock(UserService.class);
       mock.create(user);
        mock.update(user);
//        doNothing().when(mock).update(user);
//        when(userService.create(any(User.class)));
//        doThrow(new RuntimeException()).when(userService.create(user));
    }

    final Map<String,Integer> msp = new HashMap<String, Integer>();


    @Test
    public void testDelete(){
        user.setId("40283a814f7e79c1014f7e7dd3a20000");
        userService.delete(user);
    }

    @Test
    public void testAnnotation(){
        System.out.println("Hello ");
    }


    @Test
    public void testListJson(){
        userService.listJSON(new User());
    }

    @Test
    public void testGet() {
        String id = "40283a814f8950ea014f895460340000";
        userService.get(id);
    }


    @Test
    public void testCreateThenGet() {
        String id = userService.create(user);
       User user =  userService.get(id);
        System.out.println(user);
    }

    @Test
    public void testList() {
        List list = userService.finaAll(user);
        System.out.println(list.size());
    }


    @Before
    public void setUser(){
        user.setName("Hello");
        user.setEmail("li@comm.cn");
        user.setPassword("123");


        Date date = new Date();
        user.setCreateDate(date);
        user.setUpdateDate(date);

    }

    @Test
    public void testGetUserByName() throws Exception {
        List<User> users = userService.getUserByName("test0");
        System.out.println("users size: "+users.size());
        for (User user :users) {
            System.out.println("user info: "+ReflectionToStringBuilder.toString(user));
        }
    }
}