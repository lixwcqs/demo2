package com.cqs.demo2.models.user.dao;

import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.user.model.V_User;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by li on 2015/12/2.
 */
@Repository
public class V_UserDao  extends BaseDao<V_User, String> {
    @Override
    public List<Criterion> getCriterions(V_User entity) {
        return null;
    }
}
