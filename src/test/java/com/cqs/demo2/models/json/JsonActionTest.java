package com.cqs.demo2.models.json;

import config.BaseTestConfig;
import com.cqs.demo2.models.json.action.JsonAction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by li on 2015/9/4.
 */
public class JsonActionTest extends BaseTestConfig {

    @Autowired
    private JsonAction jsonAction;

    @Test
    public void testJson() throws Exception {
        System.out.println( jsonAction.json());
    }
}