package com.baidu.chunlei.exercise.array;

import java.util.ArrayList;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-3-5
 * @version
 * @todo 
 */
public class TestAdd {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // java.lang.IndexOutOfBoundsException
        ArrayList<String> arrayList = new ArrayList<String>(){{add(2,"2");}};
    }

}
