package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-25
 * @version
 * @todo 
 */
public class CompareStringNothing {
	String s = "";
	long n = 10000000;
 
	private void function1() {
		long startTime = System.currentTimeMillis();
 
		for(long i = 0; i < n; i++) {
			if(s == null || s.equals(""));
		}
		long endTime = System.currentTimeMillis();
 
		System.out.println("function 1 use time: "+ (endTime - startTime) +"ms");
	}
 
	private void function2() {
		long startTime = System.currentTimeMillis();
 
		for(long i = 0; i < n; i++) {
			if(s == null || s.length() <= 0);
		}
		long endTime = System.currentTimeMillis();
 
		System.out.println("function 2 use time: "+ (endTime - startTime) +"ms");
	}
 
	private void function3() {
		long startTime = System.currentTimeMillis();
 
		for(long i = 0; i < n; i++) {
			if(s == null || s.isEmpty());
		}
		long endTime = System.currentTimeMillis();
 
		System.out.println("function 3 use time: "+ (endTime - startTime) +"ms");
	}
 
	public static void main(String[] args) {
		CompareStringNothing com = new CompareStringNothing();
		com.function1();
		com.function2();
		com.function3();
	}
}
