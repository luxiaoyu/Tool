package com.baidu.chunlei.exercise.inherit;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-3-10
 * @version
 * @todo
 */
public class Child extends Parent {
    static {
        sList.add("sChild");
    }

    public Child() {
        aList.add("Child");
        System.out.println("class:"+this.getClass());
    }

    public void foo() {
        System.out.println("Child");
    }

    public static void print() {
        System.out.println("child:");
        for (String string : sList) {
            System.out.println(string);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Parent p = new Parent();
        Child c = new Child();
        //        c.print();
        //
        //        System.out.println("parent:");
        //        for (String string : p.aList) {
        //            System.out.println(string);
        //        }

//        c.foo();
//        Parent pc = (Parent) c;
//        pc.foo();
//        p.foo();
        Parent.print();
        Child.print();

    }

}
