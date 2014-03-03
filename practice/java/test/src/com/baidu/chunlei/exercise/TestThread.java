package com.baidu.chunlei.exercise;

/**
 * test threads work together
 * 
 * @author luxiaoyu01@baidu.com
 * @date 2013-11-18
 * @version
 * @todo
 */

class MyThread extends Thread {
    // ��һ��Ҫ�����Ա������ÿ���������Լ��ĳ�Ա����൱��û����
    private static String mutex = "";

    public void work() throws InterruptedException {
        while (true) {
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getId());
                mutex.notifyAll();
                mutex.wait();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class TestThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        //        new MyThread().start();
        //        new MyThread().start();
        //        new MyThread().start();
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
