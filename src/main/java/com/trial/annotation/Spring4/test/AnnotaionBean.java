package com.trial.annotation.Spring4.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Map;

@Import(AnnotaionBean.DAO.class)
@Configuration
public class AnnotaionBean implements DefaultIface {

    public String name = "annotaionBeanNa";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotaionBean.class);

        //会有两个Main实例, 一个是config实例, 用来做配置解析, 一个是我们@Bean注解的实例.
        Map<String, AnnotaionBean> bean = context.getBeansOfType(AnnotaionBean.class);
        System.out.println(bean);
        System.out.println(bean.get(null));

        DAO dao = context.getBean(AnnotaionBean.DAO.class);
        System.out.println(dao);


        context.close();
    }

    @Override
    public String toString() {
        return AnnotaionBean.class.getSimpleName() + "\t[name=" + name + "]";
    }

    public static  class DAO {
    }
}

interface DefaultIface {

//    @Bean
    default AnnotaionBean getMain() {
        AnnotaionBean ab = new AnnotaionBean();
        ab.name = "iface";
        return ab;
    }
}