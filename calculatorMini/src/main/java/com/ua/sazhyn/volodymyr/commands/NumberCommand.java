package com.ua.sazhyn.volodymyr.commands;

import com.ua.sazhyn.volodymyr.commands.Command;
import com.ua.sazhyn.volodymyr.commands.editor.Editor;

import java.util.Scanner;

public class NumberCommand extends Command {

    private String number;
    public NumberCommand(Editor editor) {
        super(editor);
    }
    @Override
    public boolean execute() {

        Scanner myScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Встановити число 'a'");
            // вводим строку
            if (myScanner.hasNextLine()) {
                number = myScanner.nextLine();
            }
            try {
                int a = Integer.parseInt(number);
                // если не получится, мы вылетим в catch
                System.out.println(a);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Це не число");
            }
        }
    }
/*
       editor.newDisplay("222");
        editor.clipboard = editor.textField.getSelectedText();
*/


/*
        System.out.println("11");
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;
        System.out.println("22");

        backup();
//        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        editor.textField.insert("editor.clipboard", editor.textField.getCaretPosition());
        return true;
*/

//        return false;
 //   }

}
