package com.ua.sazhyn.volodymyr.commands.editor;

import com.ua.sazhyn.volodymyr.commands.*;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Editor {
    public JTextArea textField;
    public void init() {
        JFrame frame = new JFrame("Калькулятор");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        Font font = new Font("Consolas", Font.BOLD, 12); // Установить стиль шрифта
        textField.setFont(font);
        buttons.setLayout(new GridLayout(6, 4));
        Editor editor = this;

        JButton button_clear =      new MyButton("C",       Color.white,    false);
        JButton button_delete =     new MyButton("Delete",  Color.white,    false);
        JButton button_plus =       new MyButton("+",       Color.white,    false);
        JButton button_minus =      new MyButton("-",       Color.white,    false);
        JButton button_multiply =   new MyButton("*",       Color.white,    false);
        JButton button_divide =     new MyButton("/",       Color.white,    false);
        JButton button_spot =       new MyButton(".",       Color.white,    false);
        JButton button_is =         new MyButton("=",       Color.pink,     true);
        JButton button_sin =        new MyButton("sin",     Color.white,    false);
        JButton button_cos =        new MyButton("cos",     Color.white,    false);
        JButton button_tan =        new MyButton("tan",     Color.white,    false);
        JButton button_log =        new MyButton("log",     Color.white,    false);
        JButton button_bracket_r =  new MyButton("(",       Color.white,    false);
        JButton button_bracket_l =  new MyButton(")",       Color.white,    false);
        JButton[] button = new MyButton[10];
        for (int i = 0; i < 10; i++) {
            button[i] = new MyButton("" + i, Color.white, true);
            String str = Integer.toString(i);
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    executeCommand(new NumberCommand(editor, str));
                }
            });
        }

        button_plus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new PlusCommand(editor));
                    }
                });

        button_minus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new MinusCommand(editor));
                    }
                });

        button_is.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new IsCommand(editor));
                    }
                });

        // Схема интерфейса калькулятора

        buttons.add(button_clear);
        buttons.add(button_delete);
        buttons.add(button_bracket_r);
        buttons.add(button_bracket_l);
        buttons.add(button_sin);
        buttons.add(button_cos);
        buttons.add(button_tan);
        buttons.add(button_log);
        buttons.add(button[7]);
        buttons.add(button[8]);
        buttons.add(button[9]);
        buttons.add(button_plus);
        buttons.add(button[4]);
        buttons.add(button[5]);
        buttons.add(button[6]);
        buttons.add(button_minus);
        buttons.add(button[1]);
        buttons.add(button[2]);
        buttons.add(button[3]);
        buttons.add(button_multiply);
        buttons.add(button_divide);
        buttons.add(button[0]);
        buttons.add(button_spot);
        buttons.add(button_is);

        buttons.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        content.add(buttons);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        command.execute();
    }
/*    private void undo() {
        if (Command.isEmpty()) return;

        Command command = Command.pop();
        if (command != null) {
            command.undo();
        }
    }*/

}