package com.baidu.chunlei.exercise;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-7-16
 * @version
 * @todo
 */
public class TestIntArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String viewString = "android.widget.ImageButton@402f8d80";
        System.out.println(viewString.substring(0, viewString.indexOf("@")));
    }

}
