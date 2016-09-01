package com.cqs.common.base.dao;

import com.cqs.common.utils.CqsStringUtil;
import com.cqs.common.utils.Page;
import com.google.common.base.Optional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2015/8/21.
 */
@Repository
//@Transactional
public abstract  class BaseDao<T, PK extends Serializable> extends HibernateDao<T,String> {

    /**
     *  获得页面传递过来的组合条件
     * @return
     */
    public abstract List<Criterion> getCriterions(T entity);


    /**
     * 查询含有约束条件的所有结果
     * 不带翻页
     * @param entity
     * @return
     */
    public List<T> findAllCriteria(T entity){
        Criteria criteria = createCriteria(entity);
        return criteria.list();
    }

    @Deprecated
    public int findAllCriteriaSize(T entity){
        Criteria criteria = createCriteria(entity);
//        List list = criteria.list();
//        logger.debug("大小： " + list.size());
//        int result = list.size();
        return  criteria.list().size();

    }

    /**
     * 查询约束：
     *根据Criterion条件创建Criteria.
     *
     * @param entity
     * @return
     */
    public Criteria createCriteria(T entity) {
//        List<Criterion> criterions = getCriterions(entity);
//        Optional<List<Criterion>> optional = Optional.fromNullable(criterions);
//        criterions = optional.or(new ArrayList<Criterion>());
        List<Criterion> criterions = Optional.fromNullable(getCriterions(entity)).or(new ArrayList<Criterion>());

        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
//        if(null != criterions) {
        for (Criterion c : criterions) {
            criteria.add(c);
        }
//        }
        return criteria;
    }

    /**
     * 符合【多条件查询】的组合记录数
     * @param entity
     * @return
     */
    public int getRecords(T entity){
        Criteria criteria = createCriteria(entity);//约束条件
        criteria.setProjection(Projections.rowCount());
//        criteria.setProjection(Projections.countDistinct("createDate"));
        return ((Long)criteria.uniqueResult()).intValue();
//        return  findAllCriteriaSize(entity);
    }

    public List<T> getAll(T entity){
        Criteria criteria = createCriteria(entity);
        return criteria.list();
    }


    /**
     * 多条件查询时
     * 返回含有部分结果集的Page对象
     * @param page
     * @param entity
     * @return
     */
    public Page<T> listPage(Page page, T entity){
        page.setTotalCount(getRecords(entity));//符合条件的总记录数
        Criteria criteria = createCriteria(entity);//约束条件
        //起始位置
        criteria.setFirstResult((page.getPageNo()-1)*page.getPageSize());
        criteria.setMaxResults(page.getPageSize());//结果集大小
        page.setResult(criteria.list());
        return page;
    }

    /**
     * 多条件查询时
     * 返回部分结果集
     * @param page
     * @param entity
     * @return
     */
    public List<T> list(Page page, T entity){
        return listPage(page,entity).getResult();
    }


    @Deprecated
    public List<T> finaAll(T entity){
        return getCurrentSession().createCriteria(getEntityClass()).list();
    }
    /**
     *不含条件
     * 返回全部结果集
     * @return
     */
    public List<T> finaAll(){
        return getCurrentSession().createCriteria(getEntityClass()).list();
    }

    /**
     * 封装特殊字符模糊查询的Criterion方法
     * @param fieldOfDB 实体属性对应的数据库字段
     * @param field  实体属性值:对应get方法
     * @return
     */
    public Criterion getCriterionWithSQlRestriction(String fieldOfDB,String field){
        return Restrictions.sqlRestriction("{alias}." + fieldOfDB + " like ? escape '/'", "%" + CqsStringUtil.escapeString(field) + "%", StandardBasicTypes.STRING );
    }

}
