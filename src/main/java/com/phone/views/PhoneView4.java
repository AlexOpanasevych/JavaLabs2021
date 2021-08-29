package com.phone.views;

import com.phone.commands.AddPhoneParamsCommand;
import com.phone.commands.AddToListCommand;
import com.phone.commands.GetDataCommandI;
import com.phone.commands.RemoveFromListCommand;
import com.phone.controllers.PhoneController4;
import com.phone.models.Phone;
import com.phone.models.PhoneModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneView4 {

    PhoneModel m_Model = new PhoneModel();

    PhoneController4 m_Controller = new PhoneController4();

    void show() {
        this.showHeader();
        this.showMenu();
        this.showFooter();
    }

    private void showFooter() {
        System.out.println("Hello, choose option to work with:");
    }


    private void showMenu() {
        System.out.println("1. Add phone");
        System.out.println("2. Add phone params");
        System.out.println("3. Remove phone");
        System.out.println("4. Show phone info");
        System.out.println("5. Undo last command");
        System.out.println("6. Redo last canselled command");
    }

    private void showHeader() {
        System.out.println("Created by Oleksandr Opanasevych");
    }

    private void option1Choosed() {
        System.out.println("Input phone type");

        Scanner scanner = new Scanner(System.in);

        String phoneType = scanner.nextLine();

        AddToListCommand cmd = new AddToListCommand(phoneType, m_Model);

        m_Controller.executeCommand(cmd);


    }
    private void option2Choosed() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input index to add params");

        int i = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Input phone parameters(name, ...)");


//        HashMap<String, String> p = new HashMap<>();
        String[] params = scanner.nextLine().split(",");

//        p.put("name", params[0]);
//        p.put("weight", params[1]);
//        p.put("screenDiagonal", params[2]);
//        p.put("memory", params[3]);
//        p.put("hasCamera", params[4]);

        AddPhoneParamsCommand cmd = new AddPhoneParamsCommand(params, i, m_Model);
        m_Controller.executeCommand(cmd);

    }
    private void option3Choosed() {
        System.out.println("Input index to remove:");
        Scanner scanner = new Scanner(System.in);

        int i = Integer.parseInt(scanner.nextLine());

        RemoveFromListCommand cmd = new RemoveFromListCommand(i, m_Model);

        System.out.println("Removing phone...");

        m_Controller.executeCommand(cmd);

        System.out.println("Removing successfully finished");
    }
    private void option4Choosed() {
        System.out.println("input index:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("Phone info:");
        GetDataCommandI cmd = new GetDataCommandI(i, m_Model);
        m_Controller.executeCommand(cmd);
    }
    private void option5Choosed() {
        System.out.println("Undoing...");
        m_Controller.undo();
    }
    private void option6Choosed() {
        System.out.println("Redoing...");
        m_Controller.redo();
    }

    public void run(){
        while (true) {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            show();

            String input;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            switch (input) {
                case "1":

                    option1Choosed();

                    break;
                case "2":

                    option2Choosed();

                    break;
                case "3":

                    option3Choosed();

                    break;
                case "4":

                    option4Choosed();

                    break;
                case "5":

                    option5Choosed();

                    break;
                case "6":

                    option6Choosed();

                    break;
                case "q":
                    System.out.println("Exiting...");
                    return;
            }
        }



    }
}
