package com.cqs.demo2.models.news.dao;

import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.news.model.News;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2015/11/6.
 */
@Repository
public class NewsDao extends BaseDao<News,String>{

    @Override
    public List<Criterion> getCriterions(News entity) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        if(null != entity) {
            if(StringUtils.isNotEmpty(entity.getAuthor())){
                criterions.add(Restrictions.eq("author", entity.getAuthor()));
            }
            if(StringUtils.isNotEmpty(entity.getContent())){
                criterions.add(getCriterionWithSQlRestriction("content", entity.getContent()));
            }
            if(StringUtils.isNotEmpty(entity.getTitle())){
                criterions.add(getCriterionWithSQlRestriction("title", entity.getTitle()));
            }
            if(0 != entity.getCategory()){
                criterions.add(Restrictions.eq("category",entity.getCategory()));
            }
        }
        return criterions;
    }

    @Override
    public Criteria createCriteria(News entity) {
        Criteria criteria =  super.createCriteria(entity);
        criteria.addOrder(Order.desc("updateDate"));
        return criteria;
    }
}
