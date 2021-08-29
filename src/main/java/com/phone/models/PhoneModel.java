package com.phone.models;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.text.html.ObjectView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class PhoneModel {
    private final ArrayList<Phone> phonesList = new ArrayList<>();

    public Phone addPhone(String type) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("file:C:/Users/Sashko/Documents/labs/src/resources/phone-bean.xml");
        Phone phone = ctx.getBean("fromBean" + type, Phone.class);
        phonesList.add(phone);
        return phone;
    }

    public void initPhone(int i, HashMap<String, String> params) {
        phonesList.get(i).init(params);
    }

    public void addPhone(Phone phone) {
        phonesList.add(phone);
    }

    public Phone removePhone(int i) {
        return phonesList.remove(i);
    }

    public void removePhone(Phone phone) {
        phonesList.remove(phone);
    }

    public Phone phone(int i) {
        return phonesList.get(i);
    }

}
