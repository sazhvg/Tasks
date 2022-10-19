package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;

public class NumberCommand extends Command {

    static String number = "";
    private String n;
    public NumberCommand(Editor editor, String n) {
        super(editor);
        this.n = n;
    }
    @Override
    public boolean execute() {
        number = number + n;
        editor.textField.insert(n, editor.textField.getCaretPosition());
        return true;
    }
}