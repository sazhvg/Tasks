package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;

import java.util.Stack;

public abstract class Command {

    public Editor editor;
    private String backup;
    static final Stack <String> history = new Stack<>();
 //   private static final Stack<Command> history = new Stack<>();

    public static final void push(String str) {
//    public static void push(Command c) {
//        history.push(c);
        history.push(str);
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
