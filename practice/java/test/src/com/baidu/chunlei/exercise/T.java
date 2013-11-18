package com.baidu.chunlei.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
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

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new T("str"));
		System.out.println(set.contains(new T("str")));//false
	}

}
