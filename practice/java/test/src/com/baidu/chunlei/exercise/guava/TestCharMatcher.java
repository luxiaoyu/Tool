package com.baidu.chunlei.exercise.guava;

import com.google.common.base.CharMatcher;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-21
 * @todo 
 */
public class TestCharMatcher {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String string = "";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');
        //去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);
        // 只保留数字和小写字母
        int index = -10;
        index = ~index - 1;
        System.out.println(index);
    }

}
