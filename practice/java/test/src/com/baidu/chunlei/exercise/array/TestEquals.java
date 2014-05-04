package com.baidu.chunlei.exercise.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-4
 * @todo 
 */
public class TestEquals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = new String[] {  "CD",  "BC", "EF", "DE", "AB"};
        String target = "A";
        int count = 10000000;
        //use list
        List testList = Arrays.asList(arr);
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            testList.contains(target);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:  " + duration / 1000000);
      
        //use set
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            set.contains(target);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet:  " + duration / 1000000);
      
        //use loop
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            for(String s: arr){
                if(s.equals(target))
                    break;
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop:  " + duration / 1000000);
    }

}
