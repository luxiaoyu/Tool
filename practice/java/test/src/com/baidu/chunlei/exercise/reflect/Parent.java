package com.baidu.chunlei.exercise.reflect;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-7
 * @version
 * @todo
 */
public class Parent {
	private String parentPrivate = "parentPrivate";
	public String parentPublic = "parentPublic";

	private void parentPrivateFunction() {
		System.out.println("I am parentStaticPrivateFunction");
	}

	public void parentPublicFunction() {
		System.out.println("I am parentStaticPublicFunction");
	}
}
