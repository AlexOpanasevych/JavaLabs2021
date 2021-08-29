package com.phone.controllers;

import com.phone.commands.PhoneCommand;
import com.phone.models.Phone;

import java.util.ArrayList;

public class PhoneController4 {
    ArrayList<PhoneCommand> m_HistoryList = new ArrayList<>();
    int m_NextUndo = -1;

    public void executeCommand(PhoneCommand command) {
        // Purge history list
        this.trimHistoryList();

        // Execute the command and add it to the history list
        command.execute();
        m_HistoryList.add(command);

        // Move the 'next undo' pointer to point to the new command
        m_NextUndo++;
    }

    public void undo() {
        // If the NextUndo pointer is -1, no commands to undo
        if (m_NextUndo < 0) return;

        // Get the Command object to be undone
        PhoneCommand command = m_HistoryList.get(m_NextUndo);

        // Execute the Command object's undo method
        command.undo();

        // Move the pointer up one item
        m_NextUndo--;
    }

    public void redo() {
        // If the NextUndo pointer points to the last item, no commands to redo
        if (m_NextUndo == m_HistoryList.size() - 1) return;

        // Get the Command object to redo
        int itemToRedo = m_NextUndo + 1;
        PhoneCommand command = m_HistoryList.get(itemToRedo);

        // Execute the Command object
        command.execute();

        // Move the undo pointer down one item
        m_NextUndo++;
    }

    private void trimHistoryList() {

        // Exit if no items in History list
        if (m_HistoryList.isEmpty()) return;

        // Exit if NextUndo points to last item on the list
        if (m_NextUndo == m_HistoryList.size() - 1) return;

        // Purge all items below the NextUndo pointer
        if (m_HistoryList.size() > m_NextUndo + 1) {
            m_HistoryList.subList(m_NextUndo + 1, m_HistoryList.size()).clear();
        }
    }
}
