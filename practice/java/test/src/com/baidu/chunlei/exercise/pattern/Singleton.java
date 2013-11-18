package com.baidu.chunlei.exercise.pattern;

import java.util.Calendar;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-16
 * @version
 * @todo
 */
public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2010, 12, 31);
		System.out.println(c.get(Calendar.YEAR) + " " + c.get(Calendar.MONTH)
				+ " " + c.get(Calendar.DAY_OF_MONTH));
	}

}
