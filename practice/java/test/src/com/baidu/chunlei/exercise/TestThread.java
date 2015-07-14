package com.baidu.chunlei.exercise;

public abstract class TestThread extends Thread {

    private boolean suspend = false;

    private String control = ""; // 只是需要一个对象而已，这个对象没有实际意义

    public void setSuspend(boolean suspend) throws InterruptedException {
        if (suspend) {
            this.wait();
        }else {
            this.notify();
        }
    }

    public boolean isSuspend() {
        return this.suspend;
    }

    public void run() {
//        while (true) {
//            synchronized (control) {
//                if (suspend) {
//                    try {
//                        control.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
        this.runPersonelLogic();
    }

    protected abstract void runPersonelLogic();
    
    public static void main(String[] args) throws Exception {
        TestThread myThread = new TestThread() {
            protected void runPersonelLogic() {
                System.out.println("myThead start");
                try {
                    System.out.println("1");
                    Thread.sleep(1000);
                    System.out.println("2");
                    Thread.sleep(1000);
                    System.out.println("3");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("myThead end");
            }
        };
        myThread.start();
        Thread.sleep(1000);
//        myThread.setSuspend(true);
        myThread.wait();
        System.out.println("myThread has stopped");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("out");
        }
        myThread.setSuspend(false);
    }
}