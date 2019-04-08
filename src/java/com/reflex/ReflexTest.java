package com.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexTest {
    public static void main(String[] args) {
        try {
            //得到他的编译文件对象  两种方式
//            Class clazzA=Person.class;
            Class clazzB=Class.forName("com.reflex.Person");
            Constructor aConstructor=clazzB.getConstructor(String.class,String.class,int.class);
            Object object = aConstructor.newInstance("1111", "付鹏鹏", 11);
            Method aMethod=clazzB.getMethod("setUserName", String.class);
            aMethod.invoke(object,"李成");
            Method bMethod=clazzB.getDeclaredMethod("returnBooleanValue",boolean.class);
            bMethod.setAccessible(true);
            System.out.println(bMethod.invoke(object,false));
            Person aPerson=(Person)object;
            aPerson.setAge(22);
            System.out.println(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
