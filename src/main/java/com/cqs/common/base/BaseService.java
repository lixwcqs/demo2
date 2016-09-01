package com.cqs.common.base;

import com.cqs.common.base.dao.BaseDao;
import com.cqs.common.utils.Page;
import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by li on 2015/8/21.
 */
@Service
@Transactional
public abstract class BaseService<T, PK extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BaseDao<T,String> baseDao;

    public BaseService() {
        printEntityClass();
    }

    private void printEntityClass(){
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class c = (Class) type.getActualTypeArguments()[0];
        logger.debug(c.toString());
    }

    public String create(T entity) {
        return baseDao.create(entity);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void delete(String id) {
        baseDao.delete(id);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public  List<T> finaAll(T entity){
        Assert.assertNotNull(entity);
        return baseDao.finaAll(entity);
    }

    public List<T> list(Page<T> page, T entity){
        Assert.assertNotNull(entity);
        return baseDao.list(page, entity);
    }


    public Page<T>  listPage(Page<T> page, T entity){
        Assert.assertNotNull(entity);
        return baseDao.listPage(page, entity);
    }

    public T get(String id){
       return baseDao.get(id);
    }



}