package com.baidu.chunlei.exercise.reflect;

public final class Child extends Parent {
	private static void staticPrivateFunction() {
		System.out.println("I am private static Function");
	}
	public String publicString = "I am publicString";
	private String privateString = "I am privateString";

	private static String staticPrivateString = "I am private static String";
	private int privateInt = 2;

	private void changePrivateString() {
		privateString = "privateString has been changed";
	}

	public void printPrivateString() {
		System.out.println(privateString);
	}

	private void privateFunction() {
		System.out.println("I am privateFunction");
	}

	public void publicFunction() {
		System.out.println("I am publicFunction");
	}

	private int testParameter(String str, int i) {
		System.out.println("String:" + str + " int:" + i);
		return i;
	}
}
