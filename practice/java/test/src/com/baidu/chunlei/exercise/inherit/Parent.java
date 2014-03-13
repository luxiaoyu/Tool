package com.baidu.chunlei.exercise.inherit;

import java.util.ArrayList;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-3-10
 * @version
 * @todo
 */
public class Parent {

    protected ArrayList<String> aList = new ArrayList<String>();
    protected static ArrayList<String> sList = new ArrayList<String>();
    
    static {
        sList.add("sParent");
    }

    public Parent() {
        aList.add("Parent");
    }
    
    public void foo(){
        System.out.println("Parent");
    }
    
    public static void print() {
        System.out.println("Parent:");
        for (String string : sList) {
            System.out.println(string);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
