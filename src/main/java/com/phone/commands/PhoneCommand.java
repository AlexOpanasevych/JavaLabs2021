package com.phone.commands;

import com.phone.models.PhoneModel;

public abstract class PhoneCommand
{
    protected PhoneModel m_Model;

    public PhoneCommand(PhoneModel model)
    {
        m_Model = model;
    }

    public abstract void execute();

    public abstract void undo();

}