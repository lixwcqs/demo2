package com.cqs.demo2.models.imageUpload.action;

import com.cqs.common.base.BaseAction;
import com.cqs.common.utils.PropertiesUtils;
import com.cqs.demo2.models.imageUpload.model.ImageUpload;
import com.cqs.demo2.models.imageUpload.service.ImageUploadService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by li on 2015/9/13.
 */
@Controller
public class ImageUploadAction extends BaseAction<ImageUpload> {

    @Autowired
    private ImageUploadService imageUploadService;

    private File imageFile ;

    private String imageFileContentType;
    private String imageFileFileName;

    private List<ImageUpload> jsonResult1;

    public String uploadImage(){
        logger.debug("Hello" + saveImageDir());
        try {
            File destFile = new File(saveImageDir() + imageFileFileName);
            FileUtils.copyFile(imageFile, destFile);
            logger.debug(String.valueOf(destFile.getAbsolutePath()));
            logger.debug(imgURL() + imageFileFileName);
            request.setAttribute("imgPath", imgURL() + imageFileFileName);
            entity.setName(imageFileFileName);
            entity.setUrl(imgURL() + imageFileFileName);
            entity.setApplyId("40283a814f7d92f7014f7d94afeb0002");
            imageUploadService.create(entity);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        return SUCCESS;
    }

    public String imgList(){
        entity.setApplyId("40283a814f7d92f7014f7d94afeb0002");
        logger.debug("Size: " + imageUploadService.finaAll(entity).size());
        jsonResult1 = imageUploadService.finaAll(entity);
        request.setAttribute("imgs", imageUploadService.finaAll(entity));
        return SUCCESS;
    }

    public String showImgs(){
        entity.setApplyId("40283a814f7d92f7014f7d94afeb0002");
        logger.debug("Size: " + imageUploadService.finaAll(entity).size());
        request.setAttribute("imgs", imageUploadService.finaAll(entity));
        return SUCCESS;
    }


    /**
     * 保存图片的目录
     * @return
     */
    public String saveImageDir(){
        return PropertiesUtils.getProrperty("projectPath")+"/src/main/webapp/images/upload/";
//        return  "http://192.168.1.116:8080"+request.getContextPath()+"/images/upload/";
    }

    public String imgURL(){
        return  "http://192.168.1.116:8080"+request.getContextPath()+"/images/upload/";
    }

    public String getImageFileFileName() {
        return imageFileFileName;
    }

    public void setImageFileFileName(String imageFileFileName) {
        this.imageFileFileName = imageFileFileName;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

//    不会被JSON格式化
    @JSON(serialize = false)
    public String getImageFileContentType() {
        return imageFileContentType;
    }

    public void setImageFileContentType(String imageFileContentType) {
        this.imageFileContentType = imageFileContentType;
    }
}
