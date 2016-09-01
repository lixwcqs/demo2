package com.cqs.demo2.models.book.service;

import com.cqs.common.utils.Page;
import com.cqs.demo2.models.book.model.Book;
import com.cqs.demo2.models.book.model.BookCategory;
import config.BaseTestConfig;
import net.mindview.util.Enums;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by li on 2015/11/8.
 */
public class BookServiceTest extends BaseTestConfig{
    @Resource
    private BookService service;
    private static  Date baseDate  = null;
    private Book book = new Book();


    private static String[] bookName = {
            "从你的全世界路过:让所有人心动的故事","解忧杂货店","白岩松:行走在爱与恨之间","狼图腾","平凡的世界","从0到1:开启商业与未来的秘密",
            "知乎金融选修课:金钱有术","大数据时代:生活、工作与思维的大变革","自控力(斯坦福大学很受欢迎的心理学课程)","你的孤独,虽败犹荣:谁的青春不迷茫系列",
            "不要让未来的你,讨厌现在的自己","时间简史","投资中最简单的事","新经济,新规则","零边际成本社会","激荡三十年:中国企业1978-2008","牛奶可乐经济学"
    };

    private static String[] publisher = {
            "人民邮电出版社","机械工业出版社","中信出版社","清华大学出版社","北京大学出版社","电子工业出版社","中国科学技术出版社",
            "中国人民大学出版社","译林出版社","湖南文化出版社"
    };

    private static String[] authors = {
            "李开复","杨传辉","罗特","刘天使","鸟哥","罗胖","爱因斯坦",
    };

    public void initBook(){
        int aIndex = (int) (Math.random() * authors.length);
        book.setAuthor(authors[aIndex]);
        getBaseDate();
        int addDay =  (int)(Math.random()*365*15);
        book.setPublishDate(DateUtils.addDays(baseDate, addDay));
        book.setUpdateDate(new Date());
        book.setCreateDate(DateUtils.addSeconds(DateUtils.addDays(baseDate, addDay), (int) (Math.random() * 3600*24)));
        System.out.println("days : " + addDay + "\t" + book.getPublishDate() + "\t" + baseDate);
//        book.setPrice((float) (Math.random()*999));
        book.setPrice( (Math.random()*999));
//        book.setSelling((float) (book.getPrice() * (0.5 + Math.random() * 0.5)));
        book.setSelling( (book.getPrice() * (0.5 + Math.random() * 0.5)));
        float discount =0.8f +  ((float)Math.random()) * 0.2f;
        book.setDiscount(discount);
        int pIndex = (int) (Math.random() * publisher.length);
        book.setPublisher(publisher[pIndex]);
        int bIndex = (int) (Math.random() * bookName.length);
        book.setName(bookName[bIndex]);
//        book.setTmp((int)(Math.random()*100000)/100.00);
        book.setStorge((int) (Math.random()*20000));
        book.setIsActive(Math.random() > 0.5);
        int cindex = (int) (Math.random() * bookName.length);
        book.setCategory(Enums.random(BookCategory.class));
    }

    public String tfinally(){
        try{
            System.out.println("try");
            return "RESULT";
        }finally {
            System.out.println("finally");
        }
    }

    @Test
    public void testFinally() throws Exception {
        tfinally();
    }

    @Test
    public void testCreate() throws Exception {

        for (int i = 0; i < 10; i++) {
            initBook();
            service.create(book);

            System.out.println(ReflectionToStringBuilder.toString(book));
        }

    }

    @Test
    public void testFind() throws Exception {
        service.finaAll(new Book());
    }

    public static void getBaseDate() {

        if (baseDate == null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                baseDate = sf.parse("2001/01/01");
            } catch (ParseException e) {
                baseDate = new Date();
            }
        }
    }
}