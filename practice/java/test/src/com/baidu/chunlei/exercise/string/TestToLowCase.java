package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-3-30
 * @todo 
 */
public class TestToLowCase {

//    private static String simpleToLowerCase(String str) {
//        int A = 'A';
//        int Z = 'Z';
//        int length = str.length();
//        StringBuilder sb = null;
//        
//        for (int i = 0; i < length; i++) {
//            char c = str.charAt(i);
//            if (c >= A && c <= Z) {
//                if (sb == null) {
//                    sb = new StringBuilder(str);
//                }
//                sb.setCharAt(i, (char) (c + delta));
//            }
//        }
//        
//        return null == sb ? str : sb.toString();
//    }
    
    final static int delta = 'a' - 'A';
    final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static String simpleToLowerCase(String str) {
        int A = 'A';
        int Z = 'Z';
        boolean changed = false;
        int length = str.length();
        char[] lowerCase = str.toCharArray();

        for (int i = 0; i < length; i++) {
            char c = lowerCase[i];
            if (c >= A && c <= Z) {
                lowerCase[i] = alphabet[c - A];
                changed = true;
            }
        }

        return changed ? new String(lowerCase) : str;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String test = "MinHeight";
        int times = 1000000;
        
        long begin = System.currentTimeMillis();
        String ret = null;
        for (int i = 0; i < times; i++) {
            ret = test.toLowerCase();
        }
        System.out.println("toLowerCase:" + (System.currentTimeMillis() - begin));
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            ret = simpleToLowerCase(test);
        }
        System.out.println("simpleToLowerCase:" + (System.currentTimeMillis() - begin));
    }

}
