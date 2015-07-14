package com.baidu.chunlei.exercise.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-3-19
 * @version
 * @todo
 */
public class ArrayToList {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        List list = Arrays.asList(array);
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());

        List list1 = Arrays.asList(1,2,3);
        System.out.println(list1.size());
        
        Integer[] arrayIntegers = { 1, 2, 3 };
        List list2 = Arrays.asList(arrayIntegers);
        System.out.println(list2.size());
        
    }

}
