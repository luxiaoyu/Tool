package com.baidu.chunlei.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-1-13
 * @version
 * @todo 
 */
public class TestMatcher {
    private static String getQueryString(String url){
        Matcher m = Pattern.compile("word=([^&]*)").matcher(url);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getQueryString("01-13 12:52:41.952: I/LightBrowserView(31752): onPageFinished url = http://m.baidu.com/s?tn=zbios&pu=sz%401320_480%2Ccuid%40ABEC6214A5359A4B1C905AB5DCACA353%257C243145140839853%2Ccua%40720_1184_android_1.0_320%2Ccut%40Galaxy%2BNexus_4.2_17_samsung%2Cosname%40baiduboxapp%2Cctv%401%2Ccfrom%40757b%2Ccsrc%40null&bd_page_type=1&word=m.baidu.com&from=757b&pkgname=null&network=1&sa=kh_1&ss=11"));
        System.out.println(getQueryString("01-13 12:54:48.366: I/LightBrowserView(31752): onPageFinished url = http://m.baidu.com/s?word=%E5%BC%A0%E8%89%BA%E8%B0%8B%E8%AE%A4%E7%BD%9A748%E4%B8%87"));
    }

}
