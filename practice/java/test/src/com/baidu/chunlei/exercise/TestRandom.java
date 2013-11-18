package com.baidu.chunlei.exercise;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-8-30
 * @version
 * @todo
 */
public class TestRandom {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++){
            int r = (int)(Math.random()*50000);
            System.out.println(r);
        }
    }
}
