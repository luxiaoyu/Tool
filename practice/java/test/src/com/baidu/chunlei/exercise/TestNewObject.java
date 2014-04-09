package com.baidu.chunlei.exercise;
/**
 * 用对象充当结构体功能，比用数组性能低10+倍。
 * 
 * @author luxiaoyu01@baidu.com
 * @since 2014-4-9
 * @todo 
 */
public class TestNewObject {
    public static class NewObject {
        int a;
        int b;
        public NewObject(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        int size = 10000000;
        long begin = System.currentTimeMillis();
        NewObject[] n = new NewObject[size];
        for (int i = 0; i < size; i++) {
            n[i] = new NewObject(i, i);
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        int[] a = new int[size];
        int[] b = new int[size];
        
        for (int i = 0; i < size; i++) {
            a[i] = i;
            b[i] = i;
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

}
