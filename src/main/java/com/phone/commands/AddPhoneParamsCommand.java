package com.phone.commands;

import com.phone.models.Phone;
import com.phone.models.PhoneModel;
import com.phone.models.Smartphone;

import java.util.HashMap;

public class AddPhoneParamsCommand extends PhoneCommand {

    private HashMap<String, String> hashParams;
    private String[] params;
    int i;

    Phone previousState;

    public AddPhoneParamsCommand(HashMap<String, String> params, int i, PhoneModel model) {
        super(model);
        this.i = i;
        this.hashParams = params;
    }

    public AddPhoneParamsCommand(String[] params, int i, PhoneModel model) {
        super(model);
        this.i = i;
        this.params = params;
    }

    @Override
    public void execute() {
        this.previousState = m_Model.phone(i).clone();
        Phone phone = m_Model.phone(i);
        phone.init(this.params);
    }

    @Override
    public void undo() {
        if(previousState != null)
            this.m_Model.phone(i).from(previousState);
    }
}
