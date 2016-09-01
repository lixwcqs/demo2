package com.cqs.common.base.dao;

import com.cqs.common.utils.GenericsUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by li on 2015/8/21.
 */
@Repository
public class HibernateDao<T, PK extends Serializable>{
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected Class<T> entityClass;
    @Resource
    private SessionFactory sessionFactory;


    public String create(final T entity){
        Assert.notNull(entity);
        String id =   getCurrentSession().save(entity).toString();
        logger.info("新增： {}" , entity.toString());
        return id;
    }

    public void delete(final T entity){
        Assert.notNull(entity, "entity 不能为null : ");
        try {
            getCurrentSession().delete(entity);
            logger.info("删除成功, 实体信息{}", entity);
        } catch (HibernateException e) {
            logger.error("删除实体{}信息异常", entity);
            throw new RuntimeException(e);
        }

    }

    public void delete(final PK id){
        try {
            getCurrentSession().delete(get(id));
            logger.info("删除成功, 实体信息{}", id);
        } catch (HibernateException e) {
            logger.error("删除实体{}信息异常", id);
            throw new RuntimeException(e);
        }

    }

    public void update(final T entity){
        Assert.notNull(entity);
        getCurrentSession().update(entity);
        logger.info("更新： {}", ReflectionToStringBuilder.toString(entity));
    }

    /**
     * 按id获取对象.
     */
    public T get(final PK id) {
        Assert.notNull(id);
        return (T) getCurrentSession().get(getEntityClass2(), id);
    }

    public HibernateDao() {
        logger.debug(String.valueOf(getEntityClass()));
    }

    /**
     * 求泛型的类类型
     * @return
     */
    protected Class<T> getEntityClass(){
//        logger.debug("this.getClass().getGenericSuperclass(): "  + this.getClass().getGenericSuperclass());
        if(null == entityClass){
            entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
//        logger.debug("entityClass: {}" , entityClass);
        return entityClass;
    }



    protected Class<T> getEntityClass2(){
        if(null == entityClass){
            entityClass = GenericsUtils.getSuperClassGenricType(getClass());
        }
        logger.debug("entityClass:{} ", entityClass);
        return entityClass;
    }

    protected Session getCurrentSession(){
//        logger.debug("" + (sessionFactory == null) +"\t" +sessionFactory.getCurrentSession().isConnected());
        return sessionFactory.getCurrentSession();
    }


    /**
     * 用于Service层直接使用SimpleHibernateDAO的构造函数.
     * eg.
     * SimpleHibernateDao<User, Long> userDao = new SimpleHibernateDao<User, Long>(sessionFactory, User.class);
     */
    public HibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }
}
