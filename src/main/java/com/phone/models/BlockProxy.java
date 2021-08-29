package com.phone.models;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BlockProxy implements InvocationHandler {
    private Object ref;

    private BlockProxy(Object ref){
        this.ref = ref;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (method.getName().toLowerCase().startsWith("get")){
            return method.invoke(ref, args);
        }
        else {
            throw new IllegalAccessException("Not allowed");
        }
    }

    public static Object newProxyInstance(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new BlockProxy(obj));
    }

}

