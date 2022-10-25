package com.ua.sazhyn.volodymyr.commands.editor;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String label, Color color, boolean opaque) {
        super(label);
        this.setBackground(color);
        this.setOpaque(opaque);
    }

}
