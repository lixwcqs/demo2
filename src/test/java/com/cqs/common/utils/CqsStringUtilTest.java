package com.cqs.common.utils;

import org.junit.Test;

/**
 * Created by li on 2015/10/27.
 */
public class CqsStringUtilTest {

    @Test
    public void testFiledLetterUp() throws Exception {
        System.out.println(CqsStringUtil.firstLetterUp("fsdf"));
        System.out.println(CqsStringUtil.firstLetterUp(""));
        System.out.println(CqsStringUtil.firstLetterUp(null));
    }
}