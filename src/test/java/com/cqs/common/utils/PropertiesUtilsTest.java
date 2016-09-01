package com.cqs.common.utils;

import config.BaseTestConfig;
import org.junit.Test;

/**
 * Created by li on 2015/9/13.
 */
public class PropertiesUtilsTest extends BaseTestConfig {

    @Test
    public void testGetPerperty() throws Exception {
        logger.debug(PropertiesUtils.getProrperty("projectPath"));
    }
}