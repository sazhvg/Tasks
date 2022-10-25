package com.ua.sazhyn.volodymyr.commands.editor;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String label, int key) {
        super(label);
        this.setMnemonic(key);// Установить горячую клавишу
    }
}
