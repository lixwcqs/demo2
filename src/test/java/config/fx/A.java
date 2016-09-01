package config.fx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Created by li on 2015/9/19.
 */
public  class A<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private T entity;
    private Class<T> entityClass;

    protected Class<T> getEntityClass(){
        if(null == entityClass){
            entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        System.out.println(this.getClass());
        System.out.println(this.getClass().getGenericSuperclass());
        System.out.println("entityClass: " + entityClass);
        return entityClass;
    }

    public A() {
        System.out.println(getEntityClass());
    }
}
