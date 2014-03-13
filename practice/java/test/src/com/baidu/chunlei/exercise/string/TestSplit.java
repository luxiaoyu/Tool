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
//        String[] s = "a".split("\\|");
//        String[] s = "R.id.name".split("\\.");
        String[] s = "@file/10".split("/");
        for (String str : s){
            System.out.println("    "+str);
        }
    }

}
