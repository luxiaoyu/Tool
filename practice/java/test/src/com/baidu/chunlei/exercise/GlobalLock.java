package com.baidu.chunlei.exercise;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-7-4
 * @version
 * @todo
 */
public class GlobalLock {

    public static int getUniqueNumberWithLock(String fileName) {
        File file = new File(fileName);
        int index = -1;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile out = new RandomAccessFile(file, "rw");
            FileChannel fcout = out.getChannel();
            FileLock flout = null;
            while (true) {
                try {
                    flout = fcout.tryLock();
                    break;
                } catch (Exception e) {
                    System.out.println("File is locked.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            String line = null;
            String lastLine = "0";
            while ((line = out.readLine()) != null) {
                lastLine = line;
            }
            index = Integer.valueOf(lastLine);
            String l = String.valueOf(++index) + System.getProperty("line.separator");
            out.write(l.getBytes());

            flout.release();
            fcout.close();
            out.close();
            out = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index;
    }

    public void runInThread() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(getUniqueNumberWithLock("test.txt"));
            }
        }).start();
    }

    public static void main(String[] args) {
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
        new GlobalLock().runInThread();
    }

}
