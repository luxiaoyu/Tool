package com.baidu.chunlei.exercise;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-12-8
 * @version
 * @todo
 */
public class Observer {
//    public interface Runnable {
//        public abstract void run();
//    }
//
//    public interface ThreadFactory {
//        Thread newThread(Runnable r);
//    }

    private static final ThreadFactory sThreadFactory = 
        new ThreadFactory() {
          private final AtomicInteger mCount = new AtomicInteger(1);

          public Thread newThread(Runnable r) {
              return new Thread(r, "AsyncTask #"
                      + mCount.getAndIncrement());
          }
      };

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
