package com.cqs.security.role.dao

import com.cqs.common.base.dao.BaseDao
import com.cqs.security.role.model.Role
import org.apache.commons.lang3.StringUtils
import org.hibernate.criterion.Criterion
import org.springframework.stereotype.Repository



/**
 * Created by li on 2016/1/8.
 */

@Repository
class RoleDao extends BaseDao<Role,String>{

    @Override
    List<Criterion> getCriterions(Role entity) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        if(entity != null){
            if(StringUtils.isNotEmpty(entity.getName())){
                criterions.add(getCriterionWithSQlRestriction("name",entity.getName()));
            }
        }
        return criterions;
    }
}
