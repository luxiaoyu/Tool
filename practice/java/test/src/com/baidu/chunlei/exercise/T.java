package com.baidu.chunlei.exercise;

import java.util.UUID;



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
	
	private static int[] test(){
	    System.out.println("test");
	    return new int[] {1,2,3};
	}

	public static void main(String[] args) {
//		for (int i : test()) {
//		    System.out.println(i);
//		}
	    System.out.println(UUID.randomUUID());
	    //#define NAME_MAX 255


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
