package com.baidu.chunlei.exercise;
/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-4-11
 * @todo 
 */
public class TestAutoBoxing {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Long sumL = 0L;
        long suml = 0L;
        int count = Integer.MAX_VALUE / 10;
        long begin = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            sumL += i;
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            suml += i;
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

}
