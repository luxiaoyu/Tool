package com.baidu.chunlei.exercise.string;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-25
 * @version
 * @todo 
 */
public class StringConcat {
	
	public static String concat1(String s1, String s2, String s3, String s4, String s5, String s6) {
        String result = "";
        result += s1;
        result += s2;
        result += s3;
        result += s4;
        result += s5;
        result += s6;
        return result;
    }

    public static String concat2(String s1, String s2, String s3, String s4, String s5, String s6) {
        StringBuffer result = new StringBuffer();
        result.append(s1);
        result.append(s2);
        result.append(s3);
        result.append(s4);
        result.append(s5);
        result.append(s6);
        return result.toString();
    }

    public static String concat3(String s1, String s2, String s3, String s4, String s5, String s6) {
        return new StringBuffer(s1.length() + s2.length() + s3.length() + s4.length() + s5.length() + s6.length())
                .append(s1).append(s2).append(s3).append(s4).append(s5).append(s6).toString();
    }

    public static String concat4(String s1, String s2, String s3, String s4, String s5, String s6) {
        return s1 + s2 + s3 + s4 + s5 + s6;
    }

    public static String concat5(String s1, String s2, String s3, String s4, String s5, String s6) {
        return new StringBuilder(s1.length() + s2.length() + s3.length() + s4.length() + s5.length() + s6.length())
                .append(s1).append(s2).append(s3).append(s4).append(s5).append(s6).toString();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 10000000;
		long startTime = 0;
		long endTime = 0;
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			concat1("", "", "", "", "", "");
		}
		endTime = System.currentTimeMillis();
		System.out.println("concat1 1 use time: "+ (endTime - startTime) +"ms");
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			concat2("", "", "", "", "", "");
		}
		endTime = System.currentTimeMillis();
		System.out.println("concat2 1 use time: "+ (endTime - startTime) +"ms");
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			concat3("", "", "", "", "", "");
		}
		endTime = System.currentTimeMillis();
		System.out.println("concat3 1 use time: "+ (endTime - startTime) +"ms");
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			concat4("", "", "", "", "", "");
		}
		endTime = System.currentTimeMillis();
		System.out.println("concat4 1 use time: "+ (endTime - startTime) +"ms");
		
		startTime = System.currentTimeMillis();
		for(long i = 0; i < n; i++) {
			concat5("", "", "", "", "", "");
		}
		endTime = System.currentTimeMillis();
		System.out.println("concat5 1 use time: "+ (endTime - startTime) +"ms");
	}

}
