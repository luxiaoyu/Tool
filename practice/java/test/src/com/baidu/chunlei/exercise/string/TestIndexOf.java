package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-17
 * @version
 * @todo 
 */
public class TestIndexOf {
    private static String getFunctionName(String property){
        String firstLetter = property.substring(0, 1).toUpperCase();
        return firstLetter + property.substring(1, property.length());
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("a/req".indexOf("/re"));
        System.out.println(getFunctionName("align"));
    }

}
