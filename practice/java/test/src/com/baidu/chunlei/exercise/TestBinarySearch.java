package com.baidu.chunlei.exercise;


/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-19
 * @todo 
 */
public class TestBinarySearch {
    public static int binarySearch(int[] a, int target) {
        if (null == a || a.length == 0) return -1;
        
        int l = 0, h = a.length - 1, m = 0;
        while (l <= h) {
            m = l + ((h - l) >> 1);
            if (a[m] == target) return m;
            else if (a[m] > target) h = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 1 }, 0));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7, 9 }, 3));
        System.out.println(binarySearch(new int[] { 2, 4, 6, 8 }, 4));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7, 9 }, 8));
        System.out.println(binarySearch(new int[] { 1, 3, 4, 7, 8, 12, 45, 67, 97, 123, 456, 675,
                1111, 4534, 4563 }, 8));
        System.out.println(binarySearch(new int[] { 1, 3, 4, 7, 8, 12, 45, 67, 97, 123, 456, 675,
                1111, 4534, 4563 }, 455));
    }

}
