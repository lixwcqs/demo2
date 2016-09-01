package com.cqs.demo2.models.imageUpload.service;

import com.cqs.common.base.BaseService;
import com.cqs.demo2.models.imageUpload.model.ImageUpload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by li on 2015/9/14.
 */
@Service
@Transactional
public class ImageUploadService extends BaseService<ImageUpload,String> {

}
