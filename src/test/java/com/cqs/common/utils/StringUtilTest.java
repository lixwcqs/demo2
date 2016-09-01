package com.cqs.common.utils;

import org.junit.Test;

/**
 * Created by li on 2015/10/27.
 */
public class StringUtilTest {

    @Test
    public void testFiledLetterUp() throws Exception {
        System.out.println(CqsStringUtil.firstLetterUp("dfasdfsDsdfs"));
        System.out.println(CqsStringUtil.firstLetterUp("DfasdfsDsdfs"));
        System.out.println(CqsStringUtil.firstLetterUp("DfasdfsDsdfs"));
    }
}