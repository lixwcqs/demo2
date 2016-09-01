package com.cqs.demo2.models.news.action;

import com.alibaba.fastjson.JSONArray;
import com.cqs.common.base.BaseAction;
import com.cqs.common.utils.Page;
import com.cqs.demo2.models.news.model.News;
import com.cqs.demo2.models.news.service.NewsService;
//import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by li on 2015/11/21.
 */
@Controller
public class NewsAction extends BaseAction<News> {

    public NewsAction() {
       logger.debug("初始化");
    }

    @Resource
    private NewsService service;

    public String listJSON() {
        jqpage.setPageNo(request.getParameter("page"));
        service.listPage(jqpage, entity);
//        news = JSONArray.fromObject(jqpage.getResult());
        news = JSONArray.toJSONString(jqpage.getResult());
//        for (int i = 0; i < news.size(); i++) {
//            logger.debug(ReflectionToStringBuilder.toString(news.get(i)));
//        }
        logger.debug("页数：" + jqpage.getPages());
        return SUCCESS;
    }

    public String list() {
        jqpage.setPageNo(request.getParameter("page"));
        Page page = service.listPage(jqpage, entity);
        request.setAttribute("page",page);
        logger.debug("页数：" + jqpage.getPages());
        return SUCCESS;
    }

    private String news = new String();

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
    //    public JSONArray getNews() {
//        return news;
//    }
//
//    public void setNews(JSONArray news) {
//        this.news = news;
//    }
}
