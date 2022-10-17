package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;
import javax.swing.*;

public class PlusCommand extends Command {

    public PlusCommand(Editor editor) {
        super(editor);
    }
    @Override
    public boolean execute() {

//        editor.clipboard = editor.textField.getSelectedText();
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;
        System.out.println("22");

        backup();
//        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        editor.textField.insert("editor.clipboard", editor.textField.getCaretPosition());
        super.itemCommand = "+";

        return true;

//        return false;
    }
}
