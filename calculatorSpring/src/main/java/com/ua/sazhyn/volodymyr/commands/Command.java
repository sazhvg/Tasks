package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;
import java.util.Stack;

public abstract class Command {

    public Editor editor;
    private String backup;
    private static String number;
    public static String itemCommand;
    //    private static final Stack<Command> history = new Stack<>();
    private static final Stack<String> history = new Stack<>();
    /* public static final void push(Command c) {
            history.push(c);
        }*/
    public static final void push(String str) {
        if (number == null || number.isEmpty()){
            history.push(str);
        }else {
            history.push(number);
            number = null;
            history.push(str);
        };
    }
/*
    public static final Command pop() {
        return history.pop();
    }
*/
    public static final boolean isEmpty() { return history.isEmpty(); }
    Command(Editor editor) {
        this.editor = editor;
    }
    void backup() {
        backup = editor.textField.getText();
    }
    public void undo() {
        editor.textField.setText(backup);
    }
    public abstract boolean execute();
}
