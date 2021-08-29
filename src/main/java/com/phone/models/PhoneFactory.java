package com.phone.models;

import com.phone.models.interfaces.AbstractFactory;

public class PhoneFactory implements AbstractFactory<Phone> {

    private PhoneFactory(){}
    private static PhoneFactory _instance = null;
    public static PhoneFactory instance() {
        if(_instance == null)
            _instance = new PhoneFactory();
        return _instance;
    }

    @Override
    public Phone create(String name) {
        switch (name) {
            case "Phone":
                return new Phone();
            case "Smartphone":
                return new Smartphone();
        }
        return null;
    }
}
