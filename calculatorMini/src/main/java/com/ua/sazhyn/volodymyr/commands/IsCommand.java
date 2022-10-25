package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;

public class IsCommand extends Command {

    private final String OPERATOR = "=";
/*
    public IsCommand(Editor editor) {
        super(editor);
    }
    @Override
    public boolean execute() {

        String str;
        if (NumberCommand.number == null || NumberCommand.number.isEmpty()){
            return false;
        } else {
            super.push(NumberCommand.number);
            NumberCommand.number = "";
            str = " = " + Integer.toString(calculate());
            super.push(OPERATOR);
            editor.textField.insert(str, editor.textField.getCaretPosition());
        }
        return true;
    }
*/

    public int calculate(){
        int resalt = 0;
        int r = 0;
        int i = 1;
        for (String s: NumberCommand.history) {
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