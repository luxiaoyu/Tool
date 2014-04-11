package com.baidu.chunlei.exercise;
/**
 * 测试final变量、final方法是否读取更快，结论final微乎其微的快。
 * 
 * 但是局部变量的赋值比static快一倍以上。
 * 
 * @author luxiaoyu01@baidu.com
 * @since 2014-4-10
 * @todo 
 */
public class TestFinal {
    private static void testFinalVar(){
        System.out.println("testFinalVar");
        final int test_final = 64;
        int test_var = 32;
        int x;
        int count = Integer.MAX_VALUE;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            x = test_var;
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            x = test_final;
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
    
    private final int finalMethod() {
        return 1;
    }
    
    private int nonFinalMethod() {
        return 1;
    }
    
    private void testFinalMethod() {
        System.out.println("testFinalMethod");
        int x;
        int count = Integer.MAX_VALUE;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            x = nonFinalMethod();
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            x = finalMethod();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
    
    static int staticVar;
    private static void testStaticVar(){
        System.out.println("testStaticVar");
        int test_var;
        int count = Integer.MAX_VALUE;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            test_var = i;
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            staticVar = i;
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        testFinalVar();
        new TestFinal().testFinalMethod();
        testStaticVar();
    }

}
