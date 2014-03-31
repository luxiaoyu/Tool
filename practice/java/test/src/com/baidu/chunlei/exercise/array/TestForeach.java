package com.baidu.chunlei.exercise.array;

import java.util.ArrayList;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-3-24
 * @todo 
 */
public class TestForeach {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> a = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
        // java.util.ConcurrentModificationException
//        for (Integer i : a) {
//            System.out.println(i);
//            a.add(i + i);
//        }
        
        for (int i = 0; i < a.size(); i++) {
          System.out.println(i);
          a.add(i + i);
        }
    }

}
