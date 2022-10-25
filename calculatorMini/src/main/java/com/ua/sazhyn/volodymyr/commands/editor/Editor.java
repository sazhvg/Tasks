package com.ua.sazhyn.volodymyr.commands.editor;

import com.ua.sazhyn.volodymyr.commands.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Editor {

    public int a;
    public int result;
    public void init() {

        JButton button_number = new MyButton("New", KeyEvent.VK_BACK_SPACE);
        JButton button_plus = new MyButton("+", KeyEvent.VK_ADD);
//        JButton button_minus       = new MyButton("-",     KeyEvent.VK_SUBTRACT);
//        JButton button_multiply    = new MyButton("*",    KeyEvent.VK_MULTIPLY);
//        JButton button_divide      = new MyButton("/",     KeyEvent.VK_SLASH);
//        JButton button_is          = new MyButton("=",     KeyEvent.VK_EQUALS);
//        JButton[] button = new MyButton[10];

        Editor editor = this;
        button_plus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new PlusCommand(editor));
                    }
                });
        button_number.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new NumberCommand(editor));
                    }
                });
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            Command.push(command);
        }
    }
}