package com.baidu.chunlei.exercise.string;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-17
 * @version
 * @todo 
 */
public class TestIndexOf {
    private static String getFunctionName(String property){
        String firstLetter = property.substring(0, 1).toUpperCase();
        return firstLetter + property.substring(1, property.length());
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("a/req".indexOf("/re"));
        System.out.println(getFunctionName("align"));
        String aString = "@ref/abc";
        System.out.println(aString.substring(5));
        System.out.println("a.b".substring(0, "a.b".indexOf('.')));
        String ref = "@file/10.png";
        String prefix = ref.substring(1, ref.indexOf('/'));
        System.out.println("prefix: " + prefix);
//        String id = ref.substring(ref.indexOf('/') + 1);
        String id = ref.substring("@file/".length());
        System.out.println("id: "+ id);
        String name = id.substring(0, id.lastIndexOf('.'));
        System.out.println(name);
        int indexPoint = ref.lastIndexOf('.');
        String suffix = ref.substring(indexPoint + 1, ref.length());
        System.out.println(suffix);
    }

}
