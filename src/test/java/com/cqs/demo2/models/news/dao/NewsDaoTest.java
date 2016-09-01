package com.cqs.demo2.models.news.dao;

import com.cqs.common.utils.Page;
import com.cqs.demo2.models.news.model.News;
import config.BaseTestConfig;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * Created by li on 2015/11/7.
 */
public class NewsDaoTest extends BaseTestConfig{

    @Resource
    private NewsDao dao;

    private News entity = new News();
    private Page<News> page = new Page<News>();

    @Test
    public void testGetRecords() throws Exception {
        entity.setContent("d7");
        StopWatch watch = new StopWatch();
        page.setPageNo(2);
        watch.start();
        int result = dao.getRecords(entity);
        watch.stop();
        System.out.println("符合要求的记录数： " + result);
        System.out.println("查询时间： " + watch.getTotalTimeSeconds() + " 秒");
    }
}