package com.baidu.chunlei.exercise;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-9
 * @version
 * @todo 
 */
public class TestFinally {
	public static boolean test(){
		boolean t = false;
		return (t = false);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(String.valueOf(TestFinally.test()));
		try {
			FileWriter fw = new FileWriter("");
		} catch (IOException e) {
			System.out.println("I am catch");
			return ;
		} finally {
			System.out.println("I am finally");
		}
		
		try {
			FileWriter fw = new FileWriter("");
		} catch (IOException e) {
			System.out.println("I am catch");
			System.exit(1);
		} finally {
			System.out.println("I am finally");
		}
	}

}
