package com.cqs.demo2.models.book.action;

import com.cqs.common.base.BaseAction;
import com.cqs.common.utils.Page;
import com.cqs.demo2.models.book.model.Book;
import com.cqs.demo2.models.book.service.BookService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by li on 2016/1/19.
 */
@Controller
@ParentPackage("json-default")
@Namespace("/book")
//jsonResult为jsonResult对象
@Results({
        @Result(name = "success", type="json", params = {
                "root","jsonResult",
                "encode","true"
        }),
        @Result(name = "error", location = "/error.jsp")
})
public class BookAction extends BaseAction <Book>{

    @Resource
    BookService bookService ;


    @Action(value = "delete" ,
            results = {}
    )
    public String delete(){
        bookService.delete(entity);
        return SUCCESS;
    }

    @Action(value = "create" ,
            results = {}
    )
    public String create(){

        Date now = new Date();
        entity.setCreateDate(now);
        entity.setUpdateDate(now);
        entity.setDiscount(entity.getSelling()/entity.getPrice());
        bookService.create(entity);
        return SUCCESS;
    }

    @Action(value = "update" ,
            results = {}
    )
    public String update(){
        logger.debug("update action");
        entity.setUpdateDate(new Date());
        entity.setDiscount(entity.getSelling()/entity.getPrice());
        bookService.update(entity);
        return SUCCESS;
    }

    @Action(value = "list" ,
            results = {}
    )
    public String list(){
        logger.debug("书籍列表查询");
        Page<Book> tpage = bookService.listPage(jqpage, entity);
        jsonResult.put("books", tpage.getResult());
        jsonResult.put("jqpage", tpage);
        return SUCCESS;
    }

}
