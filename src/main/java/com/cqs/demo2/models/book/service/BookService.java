package com.cqs.demo2.models.book.service;

import com.cqs.common.base.BaseService;
import com.cqs.common.base.dao.BaseDao;
import com.cqs.demo2.models.book.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by li on 2015/11/8.
 */
@Service
@Transactional
public class BookService extends BaseService<Book,String> {
    @Resource
    @Qualifier(value = "bookDao")
    private BaseDao bookDao;
}
