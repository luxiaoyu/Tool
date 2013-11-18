package com.baidu.chunlei.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class FileProgrameLock implements Lock {
    private String   callerThreadID = null;
    private String   lockFileName   = null;
    FileChannel      channel        = null;
    private FileLock lock           = null;

    public static Lock get(String fileName, String callerThreadID) {
        FileProgrameLock d = new FileProgrameLock(fileName);
        d.callerThreadID = callerThreadID;
        return (Lock) d;
    }

    public FileProgrameLock(String lockFileName) {
        this.lockFileName = lockFileName;
    }

    /**
     * 检测是否被锁定-不建议使用
     * 
     * @return true被锁定 ,false空闲
     * @deprecated
     * */
    public boolean isLocked() throws FileNotFoundException {
        File tf = new File(lockFileName);
        if (!tf.exists()) {
            return false;
        }
        FileChannel __channel = new RandomAccessFile(tf, "rw").getChannel();
        FileLock tl = null;
        try {
            tl = __channel.tryLock();
            if (tl == null) {
                return true;
            } else {

                return false;
            }
        } catch (OverlappingFileLockException e) {
            return true;
        } catch (IOException e) {
            return true;
        } catch (Exception e) {
            return true;
        } finally {
            try {
                if (tl != null) {
                    tl.release();
                }
                tl = null;
                if (__channel.isOpen()) {
                    __channel.close();
                }
                __channel = null;
                tf = null;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 获取锁资源
     * 
     * @return true成功锁定目标资源 ,false锁定操作失败
     * */
    public boolean obtain() throws IOException {
        File tf = new File(lockFileName);
        createFile();
        channel = new RandomAccessFile(tf, "rw").getChannel();
        try {
            //          System.out.println("get lock 000 >>>>>>>>>>>>>>>");  
            lock = channel.lock();
            //          System.out.println("get lock >>>>>>>>>>>>>>>");  
            return true;
        } catch (OverlappingFileLockException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 释放锁
     * */
    public void unlock() {
        try {
            if (lock != null) {
                lock.release();
            }
            System.out.println(callerThreadID + " unlock XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ");
            if (channel != null && channel.isOpen()) {
                channel.close();
            }
            lock = null;
            channel = null;
            this.deleteFile();
        } catch (IOException e) {
        }
    }

    protected void finalize() throws Throwable {
        System.out.println(callerThreadID + this.getClass() + " .finalize()");
        super.finalize();
    }

    private void createFile() throws IOException {
        try {
            File tf = new File(lockFileName);
            if (!tf.exists()) {
                tf.createNewFile();
            }
            tf = null;
        } catch (IOException e) {
            System.out.println(e + lockFileName);
            throw e;
        }
    }

    private void deleteFile() {
        File tf = new File(lockFileName);
        if (tf.exists()) {
            tf.delete();
        }
        tf = null;
    }

    @Override
    public void lock() {
        // TODO Auto-generated method stub

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}
