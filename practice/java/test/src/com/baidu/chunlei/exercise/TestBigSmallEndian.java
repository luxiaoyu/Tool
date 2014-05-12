package com.baidu.chunlei.exercise;
/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-7
 * @todo 
 */
public class TestBigSmallEndian {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 0x89504e47;
        System.out.println(Integer.toBinaryString(i));
        int reverseI = Integer.reverse(i);
        System.out.println(Integer.toBinaryString(reverseI));
    }

}
