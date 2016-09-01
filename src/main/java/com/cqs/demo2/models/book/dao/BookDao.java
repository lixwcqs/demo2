package com.cqs.demo2.models.book.dao;

import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.book.model.Book;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2015/11/8.
 */
@Repository
public class BookDao  extends BaseDao<Book,String>{

    @Override
    public List<Criterion> getCriterions(Book entity) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        if(entity != null){
            if(StringUtils.isNotEmpty(entity.getName())){
//                criterions.add(getCriterionWithSQlRestriction("name",entity.getName()));
                criterions.add(Restrictions.eq("name",entity.getName()));
            }
        }
        return criterions;
    }
}
