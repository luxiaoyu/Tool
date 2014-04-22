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
    public static ArrayList<String> splitViaIndexOf(String target, String token) {
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
        return strings;
    }

    public static ArrayList<String> splitWithStringTokenizer(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        ArrayList<String> split = new ArrayList<String>();
        int i = 0;
        while (st.hasMoreTokens()) {
            split.add(st.nextToken());
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
        String string = "a:::::bc:::::def:::::g:::::abcdfe";
        String token = ":::::";
        ArrayList<String> splits = null;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            string.split(token);
        }
        System.out.println("split:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            splits = splitViaIndexOf(string, token);
        }
        System.out.println("splitViaIndex:" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            splitWithStringTokenizer(string);
        }
        System.out.println("splitWithStringTokenizer:" + (System.currentTimeMillis() - begin));
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
