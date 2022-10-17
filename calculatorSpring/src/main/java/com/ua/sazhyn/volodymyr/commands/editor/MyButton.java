package com.ua.sazhyn.volodymyr.commands.editor;

import com.ua.sazhyn.volodymyr.commands.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String label, Color color, Font font, boolean opaque, int key) {
        super(label);
        this.setFont(font);
        this.setBackground(color);
        this.setOpaque(opaque);
        this.setMnemonic(key);// Установить горячую клавишу
        this.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new NumberCommand(editor, label));
                    }

                });
    }
    public MyButton(String label, Color color, Font font, boolean opaque) {
        super(label);
        this.setFont(font);
        this.setBackground(color);
        this.setOpaque(opaque);
        this.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new NumberCommand(editor, 1));
                    }

                }
    });
}
