package com.baidu.chunlei.exercise.string;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-10
 * @version
 * @todo 
 */
public class TestSplit {
    public static String[] splitViaIndexOf(String target, String token) {
        int fromIndex = 0;
        int index = 0;
        int size = target.length() / (token.length() + 1);
        ArrayList<String> strings = new ArrayList<String>(size);
        while ((index = target.indexOf(token, fromIndex)) != -1) {
            if (index > fromIndex) {
                strings.add(target.substring(fromIndex, index));
            }
            fromIndex = index + token.length();
        }

        // 忽略fromIndex恰好是结尾的情况
        if (target.length() != fromIndex) {
            strings.add(target.substring(fromIndex, target.length()));
        }
        return strings.toArray(new String[strings.size()]);
    }
    
    public static String[] splitWithStringTokenizer(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        String[] split = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            split[i++] = st.nextToken();
        }
        return split;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
//        String[] s = "a".split("\\|");
//        String[] s = "R.id.name".split("\\.");
        //        String[] s = "@file/10".split("/");
        int count = 100000;
        String test = "a:::::bc:::::def:::::g:::::abcdfe";
        String token = ":::::";
        String[] splits = null;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            splits = test.split(token);
        }
        System.out.println("split:" + (System.currentTimeMillis() - begin));
        for (String str : splits) {
            System.out.println("@" + str);
        }
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            splits = splitViaIndexOf(test, token);
        }
        System.out.println("splitViaIndex:" + (System.currentTimeMillis() - begin));
        for (String str : splits) {
            System.out.println("@" + str);
        }
        
        String aString = "abc";
        System.out.println(aString.substring(3, 3));
//        begin = System.currentTimeMillis();
//        for (int i = 0; i < count; i++) {
//            splitWithStringTokenizer(test);
//        }
//        System.out.println("splitWithStringTokenizer:"+(System.currentTimeMillis() - begin));
//        String base = "a=b=";
//        int index = base.indexOf('=');
//        String rule = base.substring(0, index);
//        String targetIdString = base.substring(index + 1, base.length());
//        System.out.println(rule);
//        System.out.println(targetIdString);
//        
//        String[] splits = splitViaIndexOf("a:bc:def:g:::", ":");
//        for (String str : splits) {
//            System.out.println("@"+str);
//        }
    }

}
