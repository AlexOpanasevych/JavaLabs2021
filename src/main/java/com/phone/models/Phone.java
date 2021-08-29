package com.phone.models;

import com.phone.models.interfaces.Entity;
import com.phone.models.interfaces.Prototype;

import java.util.HashMap;

public class Phone implements Entity, Prototype<Phone> {

    String name;
    int weight;
    double screenDiagonal;
    int memory;
    boolean hasCamera;

    public Phone() {
        this.name = "default";
        this.hasCamera = true;
        this.memory = 64;
        this.screenDiagonal = 5;
        this.weight = 100;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getScreenDiagonal() {
        return screenDiagonal;
    }
    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }
    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public boolean isHasCamera() {
        return hasCamera;
    }
    public void setHasCamera(boolean hasCamera) {
        this.hasCamera = hasCamera;
    }
    public Phone(String name, int weight, double screenDiagonal, int memory, boolean hasCamera) {
        System.out.println("Phone constuctor");
        this.name = name;
        this.weight = weight;
        this.screenDiagonal = screenDiagonal;
        this.memory = memory; // in gigabytes
        this.hasCamera = hasCamera;
    }
    @Override
    public String toString() {
        return "Phone [hasCamera=" + hasCamera + ", memory=" + memory + ", name=" + name + ", screenDiagonal="
                + screenDiagonal + ", weight=" + weight + "]";
    }


    public void printData(){
        System.out.println(this.toString());
    }

    public int runAllAnnotatedMethods(){return 0;}

    @Override
    public void setFoo() {
    }

    @Override
    public int getFoo() {
        return 0;
    }

    public void init(HashMap<String, String> params) {
        this.setName(params.get("name"));
        this.setWeight(Integer.parseInt(params.get("weight")));
        this.setScreenDiagonal(Double.parseDouble(params.get("screenDiagonal")));
        this.setMemory(Integer.parseInt(params.get("memory")));
        this.setHasCamera(Boolean.parseBoolean(params.get("hasCamera")));
    }

    public void init(String[] params) {
        this.setName(params[0]);
        this.setWeight(Integer.parseInt(params[1]));
        this.setScreenDiagonal(Double.parseDouble(params[2]));
        this.setMemory(Integer.parseInt(params[3]));
        this.setHasCamera(Boolean.parseBoolean(params[4]));
    }

    @Override
    public Phone clone() {
        Phone phone = new Phone();
        phone.setHasCamera(this.hasCamera);
        phone.setMemory(this.memory);
        phone.setName(this.name);
        phone.setScreenDiagonal(this.screenDiagonal);
        phone.setWeight(this.weight);
        return phone;
    }

    public void from(Phone previousState) {
        setHasCamera(previousState.hasCamera);
        setMemory(previousState.memory);
        setName(previousState.name);
        setScreenDiagonal(previousState.screenDiagonal);
        setWeight(previousState.weight);
    }
}