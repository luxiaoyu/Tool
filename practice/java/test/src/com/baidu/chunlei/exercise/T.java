package com.baidu.chunlei.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-16
 * @version
 * @todo
 */
class T {
	private String str;

	T(String str) {
		this.str = str;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof T)){
			return false;
		}
		T t = (T)obj;
		return t.equals(this.str);
	}
	
	@Override
	public int hashCode() {
		return 37 * this.str.hashCode();
	}
	
	private static int count (int currentIndex, int offset, int count){
	    return (currentIndex + offset + count) % count;
	}

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new T("str"));
		System.out.println(set.contains(new T("str")));//false
//		System.out.println(1%0);
//		System.out.println(count(3,1,4));
//		System.out.println(count(0,-1,4));
//		System.out.println(count(2,-1,4));
		
//		Object property = null;
//		float f = (Float) property;
//		System.out.println(f);
		
		System.out.println("aa"+Integer.valueOf("").floatValue());
	}

}
