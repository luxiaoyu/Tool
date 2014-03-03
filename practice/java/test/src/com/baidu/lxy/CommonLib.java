package com.baidu.lxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-3-3
 * @version
 * @todo
 */
public class CommonLib {

    public static String[] splitWithStringTokenizer(String str) {
        StringTokenizer st = new StringTokenizer(str, ",");
        String[] split = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            split[i++] = st.nextToken();
        }
        return split;
    }

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
     * @param oldArray
     *            the old array, to be reallocated.
     * @param newSize
     *            the new array size.
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

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
