package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;

public class MinusCommand extends Command {

    private final String OPERATOR = "-";
    public MinusCommand(Editor editor) {
        super(editor);
    }
    @Override
    public boolean execute() {

        if (NumberCommand.number == null || NumberCommand.number.isEmpty()){
            return false;
        } else {
            super.push(NumberCommand.number);
            NumberCommand.number = "";
            super.push(OPERATOR);
            editor.textField.insert(" - ", editor.textField.getCaretPosition());
        }
        return true;
    }
}
