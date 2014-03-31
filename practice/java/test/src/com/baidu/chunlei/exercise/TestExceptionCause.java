package com.baidu.chunlei.exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-3-26
 * @todo 
 */
public class TestExceptionCause {
    public static void test(){
        throw new RuntimeException("throw from test");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Method method = TestExceptionCause.class.getDeclaredMethod("test", new Class[] {});
            method.invoke(null, new Object[]{});
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
            if (e.getCause() instanceof RuntimeException){
                e.getCause().printStackTrace();
            }
        }
    }

}
