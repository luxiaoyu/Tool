package com.baidu.chunlei.exercise.string;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-26
 * @version
 * @todo 
 */
public class StringGetChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		long n = 10000000;
		long startTime = 0;
		long endTime = 0;
		char t;
		
		startTime = System.currentTimeMillis();
		char[] arr = str.toCharArray();
		for(long i = 0; i < n; i++) {
			t = arr[25];
		}
		endTime = System.currentTimeMillis();
		System.out.println("toCharArray use time: "+ (endTime - startTime) +"ms");
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			t = str.charAt(25);
		}
		endTime = System.currentTimeMillis();
		System.out.println("charAt use time: "+ (endTime - startTime) +"ms");
	}

}
