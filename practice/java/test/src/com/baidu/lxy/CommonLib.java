package com.baidu.lxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-3-3
 * @version
 * @todo
 */
public class CommonLib {

    public static byte[] Inputstream2Bytes(InputStream input) {
        byte[] byt = null;
        if (null == input) {
            return byt;
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b = 0;
        try {
            while ((b = input.read()) != -1) {
                baos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byt = baos.toByteArray();
        return byt;
    }

    /**
     * Reallocates an array with a new size, and copies the contents of the old array to the new
     * array.
     * 
     * @param oldArray the old array, to be reallocated.
     * @param newSize the new array size.
     * @return A new array with the same contents.
     */
    public static Object resizeArray(Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class<?> elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0) {
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        }
        return newArray;
    }

    public static long time(CallBack callback) {
        long begin = System.currentTimeMillis();
        callback.doSomething();
        return System.currentTimeMillis() - begin;
    }

    public interface CallBack<T> {
        T doSomething();
    }
    

    /**
     * 生成指定长度的随机正整数。
     * 
     * @param length 随机数长度，不能大于19。因为a long can have 2(63)-1 is 9223372036854775807
     *               Long.MAX_VALUE = 19位
     * @return 随机正整数
     */
    public static long generateRandomNumber(int length) {
        if (length >= 19) {
            return -1;
        }
        long range = (long) Math.pow(10, length - 1);
        long max = 9 * range;
        long base = 1 * range;
        return (long) (Math.random() * max + base);
    }
}
