package com.baidu.chunlei.exercise.guava;

import com.google.common.base.CaseFormat;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-21
 * @todo
 */
public class TestCaseFormat {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // returns "constantName"
        String ret = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
        System.out.println(ret);
    }

}
