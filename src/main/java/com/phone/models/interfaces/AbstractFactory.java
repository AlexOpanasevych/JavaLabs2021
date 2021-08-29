package com.phone.models.interfaces;

public interface AbstractFactory<T> {
    T create(String type);
}
