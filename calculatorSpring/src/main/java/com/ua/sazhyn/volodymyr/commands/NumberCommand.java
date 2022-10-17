package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.Command;
import com.ua.sazhyn.volodymyr.commands.editor.Editor;

public class NumberCommand extends Command {


    public NumberCommand(Editor editor, String str) {
        super(editor);
    }
    @Override
    public boolean execute() {



 //       editor.newDisplay("222");
////        editor.clipboard = editor.textField.getSelectedText();

        System.out.println("11");
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;
        System.out.println("22");

        backup();
//        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        editor.textField.insert("editor.clipboard", editor.textField.getCaretPosition());
        return true;

//        return false;
    }
}
