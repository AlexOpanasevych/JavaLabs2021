package com.phone.commands;

import com.phone.models.PhoneModel;

public class GetDataCommandI extends PhoneCommand {

    private int i;
    private int dataLength;

    public GetDataCommandI(int i, PhoneModel model) {
        super(model);
        this.i = i;
    }

    @Override
    public void execute() {
        String output = m_Model.phone(i).toString();
        dataLength = output.length();
        System.out.println(output);
    }

    @Override
    public void undo() {
        for (int i = 0; i < dataLength; i++) {
            System.out.println('\b');
        }
    }
}
