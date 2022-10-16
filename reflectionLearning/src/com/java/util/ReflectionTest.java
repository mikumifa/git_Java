package com.java.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class cls=Class.forName("com.java.util.cat");
        Object o=cls.newInstance();
        Method hi= cls.getMethod("hi");
        Class<Integer> cls1 = int.class;
        Class<String> cls2 = String.class;
        Class<int[]> asd = int[].class;


        hi.invoke(o);
    }
}
class cat{
    public void hi(){
        System.out.println("hello");
    }
}