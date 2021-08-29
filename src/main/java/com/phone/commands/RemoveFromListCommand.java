package com.phone.commands;

import com.phone.models.Phone;
import com.phone.models.PhoneModel;

import java.util.HashMap;

public class RemoveFromListCommand extends PhoneCommand {

    Phone phone;
    int i;

    public RemoveFromListCommand(int i, PhoneModel model) {
        super(model);
        this.i = i;
    }

    public RemoveFromListCommand(Phone i, PhoneModel model) {
        super(model);
        this.phone = i;
    }

    @Override
    public void execute() {
        if(phone != null)
            m_Model.removePhone(phone);
        else phone = m_Model.removePhone(i);
    }

    @Override
    public void undo() {
        if(phone != null)
            m_Model.addPhone(phone);
    }
}
