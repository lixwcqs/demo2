package com.cqs.demo2.models.groovy.dao

import com.cqs.common.base.dao.BaseDao
import com.cqs.demo2.models.groovy.model.Groovy
import org.hibernate.criterion.Criterion
import org.springframework.stereotype.Repository

/**
 * Created by li on 2015/11/30.
 */
@Repository
class GroovyDao extends BaseDao<Groovy,String>{
    @Override
    List<Criterion> getCriterions(Groovy entity) {
        return null
    }
}
