package com.baidu.chunlei.exercise;

import java.util.Random;

/**
 * 测试顺序访问和随机访问的性能差异
 * 
 * @author luxiaoyu01@baidu.com
 * @since 2014-4-9
 * @todo 
 */
public class TestCache {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        // size必须保证大于cache
        final int size = 10000000;
        int[] a = new int[size];
        int x = 0;
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        
        long begin = System.currentTimeMillis();
        // 顺序访问
        for (int i = 0; i < size; i++) {
            int j = r.nextInt() % size;
            int k = j < 0 ? j * -1 : j;
            x = a[i];
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        // 头尾交替，模拟随机访问
        for (int i = 0; i < size; i++) {
            int j = r.nextInt() % size;
            int k = j < 0 ? j * -1 : j;
            x = a[k];
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

}
