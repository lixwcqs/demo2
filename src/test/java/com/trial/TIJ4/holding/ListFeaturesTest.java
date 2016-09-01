package com.trial.TIJ4.holding;

import java.sql.*;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by li on 2016/2/11.
 */
public class ListFeaturesTest {

    private Random rand = new Random(47);

    public void testName() throws Exception {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }

        HashMap m = new HashMap<>();
        m.keySet();

        String url="jdbc:mysql://localhost:3306/mysql";    //JDBC的URL
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root","");
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.print("成功连接到数据库！");
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws Exception {
        Long sum = 0L;
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        watch.stop();
        System.out.println("sum = " + sum + "\ttotal time: " + watch.getLastTaskTimeMillis());
        long sum2 = 0l;
        watch.start();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum2 += i;
        }
        watch.stop();
        System.out.println("sum2 = " + sum2 + "\ttotal time: " + watch.getLastTaskTimeMillis());
        Random r ;
        Integer t;
    }

    @Test
    public void testShuffle() throws Exception {
        int size = 108;
        Integer[] arr = new Integer[size];
        Integer[] arr2 = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i+1;
            arr2[i] = i + 50;
        }

        String print = Arrays.toString(arr);
        System.out.println(print);

        List<Integer> col = Arrays.asList(arr);
        List<Integer> col2 = Arrays.asList(arr2);
        Collections.shuffle(col);
        System.out.println("col shuffle: " + col);
        System.out.println("col2: " + col2);
        List<Integer> subList1 = col.subList(0, 50);
        List<Integer> subList2 = col2.subList(60, 107);
        System.out.println("================");
        System.out.println("sublist1: " + subList1);
        System.out.println("sublist2: " + subList2);
        try {
            col.removeAll(subList1);
            System.out.println("col remove all size: " + col.size());
            System.out.println(col);
        } catch (Exception e) {
            System.err.println(e);
        }
        try {
            col.addAll(subList2);
            System.out.println("col add all size: " + col.size());
            System.out.println(col);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}