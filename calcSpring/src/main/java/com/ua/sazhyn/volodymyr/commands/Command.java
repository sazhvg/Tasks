package com.ua.sazhyn.volodymyr.commands;

import java.util.Stack;

public abstract class Command {

    static final Stack <String> history = new Stack<>();

    public static final void push(String str) {
        history.push(str);
    }

    public static int calculate(){

        int resalt = 0;
        int r = 0;
        int i = 1;
        for (String s: history) {
            switch (s) {
                case "+":
                    i = 1;
                    break;
                case "-":
                    i = -1;
                    break;
                default:
                    try {
                        r = Integer.valueOf(s);
                        resalt += i*r;
                        i = 1;
                    } catch (NumberFormatException e) {
                        System.err.println("Невірний формат строки!");
                    }
            }
        }
        return resalt;
    }
}
