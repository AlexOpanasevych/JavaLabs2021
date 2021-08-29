package com.phone.views;

import com.phone.models.Phone;

import java.util.Scanner;

public class PhoneView {

    public void show(Phone phone){
        phone.printData();
    }

    public String inputPhoneType() {
        System.out.println("Enter phone type('Phone' to use mobile phone or 'Smartphone' to use smartphone):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String input(String additionalPrompt){
        System.out.println("Enter phone parameters(" + additionalPrompt + "):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showInputError(String s) {
        System.out.println("InputError: " + s);
    }
}
