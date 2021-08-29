package com.phone.commands;

import com.phone.models.Phone;
import com.phone.models.PhoneModel;

import java.util.HashMap;

public class AddToListCommand extends PhoneCommand {

    private Phone phone;
    private String type;
//    private HashMap<String, String> params;

    public AddToListCommand(String type, PhoneModel model) {
        super(model);
        this.type = type;
    }

    @Override
    public void execute() {
        phone = m_Model.addPhone(type);
    }

    @Override
    public void undo() {
        m_Model.removePhone(phone);
    }
}
