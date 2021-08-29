package com.phone.controllers;

import com.phone.models.Phone;
import com.phone.models.Smartphone;
import com.phone.views.PhoneView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PhoneController {
    public Phone phone;
    public final PhoneView phoneView;


    public PhoneController(PhoneView phoneView, Phone phone) {
        this.phoneView = phoneView;
        this.phone = phone;
    }


    public void execute() throws Throwable{
        String input = "";
//        do {
//            input = phoneView.inputPhoneType();
//        }while (!(input.equals("Phone") || input.equals("Smartphone")));

//        switch (input) {
//            case "Phone":
//                phone = new lab1.Phone();
//                break;
//            case "Smartphone":
//                phone = new lab1.Smartphone();
//                break;
//        }

        boolean isOk = true;
        int times = 3;
        do {
            String tokens = phone.getClass().getCanonicalName();//.split(".")*/;
            input = phoneView.input(tokens);//tokens[tokens.length - 1]);

            String[] splitted = input.split(",");

            if(phone instanceof Smartphone) {
                try {
                    if(splitted.length < 8) {
                        throw new RuntimeException();
                    }
                } catch (RuntimeException r) {
                    this.phoneView.showInputError("Type more parameters(8), available times: " + times);
                    isOk = false;
                    if(times-- == 0) throw new RuntimeException("You don't have more times to input");
                }
            }
            else {
                try {
                    if (splitted.length <= 5) {
                        throw new RuntimeException();
                    }

                } catch (RuntimeException r) {
                    this.phoneView.showInputError("Type more parameters(5), available times: " + times);
                    isOk = false;
                    if(times-- == 0) throw new RuntimeException("You don't have more times to input");
                }
            }

            if(isOk) phone.init(splitted);
        }while (!isOk);
        phoneView.show(this.phone);
    }


}
