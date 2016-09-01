package com.trial.lambda;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

/**
 * Created by li on 2015/11/26.
 */
public class LambdaTrail  implements CurrencyConverter{

    String[] atp = {"Rafael Nadal", "Novak Djokovic",  "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
            "Andy Murray", "Tomas Berdych",  "Juan Martin Del Potro"};

    List<String> players = Arrays.asList(atp);

    public void f1() {



        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println("\r\n--------------------------------------------------------------\r\n");

        System.out.println("==================使用 lambda 表达式以及函数操作=================");
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println("\r\n--------------------------------------------------------------\r\n");

        System.out.println("==================在 Java 8 中使用双冒号操作符(double colon operator)=================");
        //在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    public void f2(){
        List list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(100);
        list.add(7);
        list.add(6);
//        Collections.sort(list,(x, y) -> y - x);
    }

    public  List f3(List<String> input, Function processor) {
        ArrayList<Object> result = new ArrayList();
        for (Object obj : input) {
            result.add(processor.apply(obj));
        }
        return result;
    }

    public void f4(){
        Arrays.asList(atp).forEach((p) -> System.out.println(p));
//        System.out.println(ReflectionToStringBuilder.toString(atp));
        String[] tmp1 = atp;
        String[] tmp2 = atp;
        String[] tmp3 = atp;
        Arrays.sort(tmp1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });
        System.out.println(ReflectionToStringBuilder.toString(tmp1));
        System.out.println("====================================================================");



        // 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) );
        Arrays.sort(tmp2, sortBySurname);
        System.out.println(ReflectionToStringBuilder.toString(tmp2));
        System.out.println("====================================================================");


        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(tmp3, (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) )
        );
        System.out.println(ReflectionToStringBuilder.toString(tmp3));
    }

    public static void main(String[] args) {
        Function<String, Integer> parseInt = s -> Integer.parseInt(s);
        System.out.println(ReflectionToStringBuilder.toString(parseInt));
        System.out.println(parseInt.apply("123"));
    }

    @Override
    public BigDecimal convert(Currency from, Currency to, BigDecimal amount) {
        return null;
    }
}

interface CurrencyConverter {
    BigDecimal convert(Currency from, Currency to, BigDecimal amount);

    //666
    default List convert2(Currency from, Currency to, List<BigDecimal> amounts) {
        List result = new ArrayList();
        for (BigDecimal amount : amounts) {
            result.add(convert(from, to, amount));
        }
        return result;
    }
}
