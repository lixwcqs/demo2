package com.cqs.demo2.models.groovy.service

import com.cqs.common.base.BaseService
import com.cqs.common.base.dao.BaseDao
import com.cqs.demo2.models.groovy.model.Groovy
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Resource

/**
 * Created by li on 2015/11/30.
 */
@Transactional
@Service
class GroovyService extends BaseService<Groovy,String> {

    @Resource(name = "groovyDao")
    private BaseDao groovyDao;
}
