package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-10
 * @version
 * @todo 
 */
public class TestSplit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] s = "a".split("\\|");
        for (String str : s){
            System.out.println("    "+str);
        }
    }

}
