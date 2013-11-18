package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-25
 * @version
 * @todo 
 */
public class StringCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello"); 
		if (s1 == s2){
			System.out.println("s1 == s2");
		}else{
			System.out.println("s1 != s2");
		}
		
		String s3 = "Hello";
		String s4 = "Hello";
		if (s3 == s4){
			System.out.println("s3 == s4");
		}else{
			System.out.println("s3 != s4");
		}
		
		// "Hell" + "o"在编译阶段就合并成常量"Hello"
		String s5 = "Hell" + "o";
		String s6 = "Hello";
		if (s5 == s6){
			System.out.println("s5 == s6");
		}else{
			System.out.println("s5 != s6");
		}
	}
}
