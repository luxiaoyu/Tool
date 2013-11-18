package com.baidu.chunlei.exercise.reflect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2013-9-26
 * @version
 * @todo
 */
public class Clone {

    public static Object clone(Object originObject) {
        try {
            //将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(originObject);
            //从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (oi.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        TestObject t1 = new TestObject(1);
        t1.a = 2;
        t1.as = new String("as_old");
//        TestObject t2 = (TestObject)Clone.clone(t1);
        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        TestObject t2 = kryo.copy(t1);
        t1.a = 3;
        t1.as = new String("as_new");
        System.out.println("t1:"+ t1.a);// should be 3
        System.out.println("t2:"+ t2.a);// should be 2
        System.out.println("t1:"+ t1.as);// should be as_new
        System.out.println("t2:"+ t2.as);// should be as_old
    }

}
