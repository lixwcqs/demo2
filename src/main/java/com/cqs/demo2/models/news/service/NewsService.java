package com.cqs.demo2.models.news.service;

import com.cqs.common.base.BaseService;
import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.news.model.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by li on 2015/11/6.
 */
@Transactional
@Service
public class NewsService extends BaseService<News,String> {

    @Resource(name = "newsDao")
    private BaseDao newsDao;

}
