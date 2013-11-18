package com.baidu.chunlei.exercise;

import java.util.ArrayList;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-7-8
 * @version
 * @todo 
 */
public class TestInteger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer>  mCursors = new ArrayList<Integer>();
        mCursors.add(0);
        Integer integer = mCursors.get(0);
        integer++;
        integer++;
        System.out.println(mCursors.get(0));
    }

}
