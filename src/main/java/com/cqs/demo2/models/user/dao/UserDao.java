package com.cqs.demo2.models.user.dao;

import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.user.model.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2015/8/21.
 */
@Repository
public class UserDao extends BaseDao<User, String> {



    public List<Criterion> getCriterions(User entity) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        if(entity != null){
            if(StringUtils.isNotEmpty(entity.getName())){
//                criterions.add(getCriterionWithSQlRestriction("name",entity.getName()));
                criterions.add(Restrictions.eq("name",entity.getName()));
            }
        }
        return criterions;
    }

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
   public List<User> getUserByName(String userName){
       User user = new User();
       user.setName(userName);
       return getAll(user);
//
   }
}
