package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;
import java.util.Stack;

public abstract class Command {

    public Editor editor;
    private static String number;
    private static final Stack<Command> history = new Stack<>();
    Command(Editor editor) {
        this.editor = editor;
    }

    public static void push(Command c) {
        history.push(c);
    }
    public abstract boolean execute();
}
