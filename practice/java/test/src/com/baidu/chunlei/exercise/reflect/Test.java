package com.baidu.chunlei.exercise.reflect;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-9-23
 * @version
 * @todo 
 */
public class Test {

    /**
     * @param args
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Child c = new Child();
        System.out.println("getPropertyNamesByType:");
        for(String str : PrivateOperator.getPropertyNamesByType(c, 0, String.class)){
            System.out.println(str);
        };
        System.out.println("getPropertyNamesByValue:");
        for(String str : PrivateOperator.getPropertyNamesByValue(c, 0, int.class, 2)){
            System.out.println(str);
        };
    }

}
