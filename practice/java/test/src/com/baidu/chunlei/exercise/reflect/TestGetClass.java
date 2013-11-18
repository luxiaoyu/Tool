package com.baidu.chunlei.exercise.reflect;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-8-7
 * @version
 * @todo 
 */
public class TestGetClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Object b = null;
        test(b);
        System.out.println(b.getClass());
    }

    private static void test(Object a){
        a = String.class;
    }
}
