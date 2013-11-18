package com.baidu.chunlei.exercise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-4-28
 * @version
 * @todo
 */
public class PrivateOperator {

    /**
     * invoke object's private method
     * 
     * @param owner
     *            : target object
     * @param classLevel
     *            : 0 means itself, 1 means it's father, and so on...
     * @param methodName
     *            : name of the target method
     * @param parameterTypes
     *            : types of the target method's parameters
     * @param parameters
     *            : parameters of the target method
     * @return result of invoked method
     * 
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static Object invokeObjectMethod(Object owner, int classLevel, String methodName, Class[] parameterTypes, Object[] parameters) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // get class
        Class ownerclass = getOwnerclass(owner, classLevel);

        // get property
        Method method = ownerclass.getDeclaredMethod(methodName, parameterTypes);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        Object result = method.invoke(owner, parameters);
        return result;
    }

    /**
     * set object's private property with custom value
     * 
     * @param owner
     *            : target object
     * @param classLevel
     *            : 0 means itself, 1 means it's father, and so on...
     * @param fieldName
     *            : name of the target field
     * @param value
     *            : new value of the target field
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static void setObjectProperty(Object owner, int classLevel, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // get class
        Class ownerclass = getOwnerclass(owner, classLevel);

        // get property
        Field field = ownerclass.getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(owner, value);
    }

    /**
     * get object's private property
     * 
     * @param owner
     *            : target object
     * @param classLevel
     *            : 0 means itself, 1 means it's father, and so on...
     * @param fieldName
     *            : name of the target field
     * @return value of the target field
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static Object getObjectProperty(Object owner, int classLevel, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // get class
        Class ownerclass = getOwnerclass(owner, classLevel);

        // get property
        Field field = ownerclass.getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        Object property = field.get(owner);
        return property;
    }

    private static Class getOwnerclass(Object owner, int classLevel) {
        Class ownerclass = owner.getClass();
        for (int i = 0; i < classLevel; i++) {
            ownerclass = ownerclass.getSuperclass();
        }
        return ownerclass;
    }

}
