package com.baidu.chunlei.exercise.string;

import com.baidu.lxy.CommonLib;

/**
 * new StringTokenizer(str, ","); 比 str.split(",");
 * 快4倍（前提是分割100000或者更多，100次以下基本一样）
 * 
 * 因为split需要编译正则表达式，而StringTokenizer只是String.indexOf
 * 
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-24
 * @version
 * @todo
 */
public class TestStringTokenizer {
    private static void useStringSplit(String str) {
        String[] split = str.split(",");
    }
    
    private static void useStringUtil(String str) {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //        int times = 1000000;
        int times = 100;
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            useStringSplit("a,b,c,d");
        }
        System.out.println("useStringSplit: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            CommonLib.splitWithStringTokenizer("a,b,c,d");
        }
        System.out.println("useStringTokenizer: " + (System.currentTimeMillis() - start));
    }

}
