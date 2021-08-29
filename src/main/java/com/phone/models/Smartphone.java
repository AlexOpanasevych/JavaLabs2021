package com.phone.models;

import com.phone.models.interfaces.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Smartphone extends Phone {
    double cpuFreq; // Hz
    int coreCount;
    int ramCapacity; // in megabytes

    public Smartphone() {
        super("Google Nexus 5", 150, 5, 64, true);
        this.cpuFreq = 1000000;
        this.ramCapacity = 3000;
        this.coreCount = 8;
    }

    public double getCpuFreq() {
        return cpuFreq;
    }

    public void setCpuFreq(double cpuFreq) {
        this.cpuFreq = cpuFreq;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public Smartphone(String name, int weight, double screenDiagonal, int memory, boolean hasCamera, double cpuFreq,
                      int coreCount, int ramCapacity) {
        super(name, weight, screenDiagonal, memory, hasCamera);
        System.out.println("Smartphone constructor");
        this.cpuFreq = cpuFreq;
        this.coreCount = coreCount;
        this.ramCapacity = ramCapacity;
    }

    @Override
    public String toString() {
        return "Smartphone [coreCount=" + coreCount + ", cpuFreq=" + cpuFreq + ", ramCapacity=" + ramCapacity + "]";
    }

    @Override
    public void printData() {
        System.out.println(this.getClass().getSuperclass().getName());
        System.out.println(this.toString());
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
    }

    @MyAnnotation
    public void method1(){System.out.println("Method 1 was called!");}
    @MyAnnotation
    public void method2(){System.out.println("Method 2 was called!");}
    @MyAnnotation
    public void method3(){System.out.println("Method 3 was called!");}

    @Override
    public int runAllAnnotatedMethods() {
        Method[] methods = this.getClass().getMethods();
        int i = 0;
        for(Method mt : methods) {
            if (mt.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    mt.invoke(this);
                    i++;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Wrong method");
                }
            }
        }
        return i;
    }

    @Override
    public void init(HashMap<String, String> params) {
        super.init(params);
        this.setCpuFreq(Double.parseDouble(params.get("cpuFreq")));
        this.setCoreCount(Integer.parseInt(params.get("coreCount")));
        this.setRamCapacity(Integer.parseInt(params.get("ramCapacity")));
    }

    @Override
    public void init(String[] params) {
        super.init(params);
        this.setCpuFreq(Double.parseDouble(params[5]));
        this.setCoreCount(Integer.parseInt(params[6]));
        this.setRamCapacity(Integer.parseInt(params[7]));
    }

    @Override
    public Phone clone() {
        Smartphone phone = new Smartphone();
        phone.setHasCamera(this.hasCamera);
        phone.setMemory(this.memory);
        phone.setName(this.name);
        phone.setScreenDiagonal(this.screenDiagonal);
        phone.setWeight(this.weight);
        phone.setCoreCount(this.coreCount);
        phone.setCpuFreq(this.cpuFreq);
        phone.setRamCapacity(this.ramCapacity);
        return phone;
    }


    @Override
    public int getFoo() {
        return super.getFoo();
    }

    @Override
    public void setFoo() {
        super.setFoo();
    }
}
