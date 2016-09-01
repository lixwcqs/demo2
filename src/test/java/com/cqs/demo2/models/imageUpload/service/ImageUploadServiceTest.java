package com.cqs.demo2.models.imageUpload.service;

import com.cqs.demo2.models.imageUpload.model.ImageUpload;
import config.BaseTestConfig;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2015/9/25.
 */
public class ImageUploadServiceTest extends BaseTestConfig {

    @Resource
    private ImageUploadService service;

    @Resource
    private ImageUpload imageUpload;

    private List<String> attrs = new ArrayList<String>();

    @org.junit.Before
    public void setImageUpload(){
        imageUpload.setName("manny to one");
        attrs.add("length");
        attrs.add("height");
        attrs.add("width");
        imageUpload.setUrl("www.test.com");
        imageUpload.setAttributes(attrs);
    }

    @Test
    public void testCreate(){
        System.out.println(service == null);
        service.create(imageUpload);
    }

    @Test
    public void testCreateThenGet(){
        String id = service.create(imageUpload);
        System.out.println(service.get(id).toString());
    }

    @Test
    public void testList(){
       List list =  service.finaAll(imageUpload);
        System.out.println(list.size());
    }
}