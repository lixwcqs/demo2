package com.cqs.demo2.models.news.service;

import com.cqs.common.utils.Page;
import com.cqs.demo2.models.news.model.News;
import config.BaseTestConfig;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by li on 2015/11/6.
 */
public class NewsServiceTest  extends BaseTestConfig{

    @Resource
    private NewsService service ;


    private News news = new News();
    private Page<News> page = new Page<News>();
    private static final String seed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private String getRandomString(int len){
       StringBuilder result = new StringBuilder();
        int seedLen = seed.length();
        for (int i = 0; i < len; i++) {
            result.append(seed.charAt((int) (Math.random() * seedLen)));
        }
        return result.toString();
    }

    public void initNews(){
        news.setTitle(getRandomString((int) (Math.random() * 30)));
        news.setAuthor(getRandomString((int) (Math.random() * 30)));
        news.setContent(getRandomString((int) (Math.random() * 800)));
        news.setCategory((int) (Math.random() * 99999));
        news.setCreateDate(new Date());
        news.setUpdateDate(new Date());
    }

    @Test
    public void testCreate() throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 1; i <= 5; i++) {
            initNews();
            service.create(news);
        }
        watch.stop();
        System.out.println("插入30W条记录所花费时间" + watch.getTotalTimeSeconds());
    }


    @Test
    public void testList() throws Exception {
        for (int i = 0; i < 1; ++i) {
            StopWatch watch = new StopWatch();
            page.setPageNo(2);
//         news.setContent("d7");

            watch.start();
            service.list(page, news);
            watch.stop();
//            System.out.println("符合要求的记录数： " + page.getTotalCount());
            System.out.println("查询时间： " + watch.getTotalTimeSeconds() + " 秒");
        }
    }
}