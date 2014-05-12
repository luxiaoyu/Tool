package com.baidu.chunlei.exercise;
/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-4
 * @todo 
 */
public class TestBit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a = 16;
        // “>>> 无符号右移,高位补0”
        System.out.println(a >>> 1);
        // “>> 右移,高位补符号位”
        System.out.println(a >> 1);
        System.out.println(a > 1);
    }

}
