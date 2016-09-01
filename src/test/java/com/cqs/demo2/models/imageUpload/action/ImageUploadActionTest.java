package com.cqs.demo2.models.imageUpload.action;

import config.BaseTestConfig;
import com.cqs.demo2.models.imageUpload.model.ImageUpload;
import com.cqs.demo2.models.imageUpload.service.ImageUploadService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by li on 2015/9/14.
 */
public class ImageUploadActionTest extends BaseTestConfig {

    @Autowired
    private ImageUploadService imageUploadService;

    @Test
    public void testUploadImage() throws Exception {
        imageUploadService.create(new ImageUpload());
    }
}

interface CurrencyConverter {
    BigDecimal convert(Currency from, Currency to, BigDecimal amount);

//    default List convert2(Currency from, Currency to, List<BigDecimal> amounts) {
//        List result = new ArrayList();
//        for (BigDecimal amount : amounts) {
//            result.add(convert(from, to, amount));
//        }
//        return result;
//    }
}