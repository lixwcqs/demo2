package com.cqs.demo2.models.imageUpload.dao;


import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.imageUpload.model.ImageUpload;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by li on 2015/9/14.
 */
@Repository
public class ImageUploadDao extends BaseDao<ImageUpload, String> {

    @Override
    public List<Criterion> getCriterions(ImageUpload entity) {
        return null;
    }


}
