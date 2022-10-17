package com.ua.sazhyn.volodymyr.commands.editor;

import com.ua.sazhyn.volodymyr.commands.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Editor {

    public JTextArea textField;
    public String clipboard = "0.0";
//    private CommandHistory history = new CommandHistory();
    public Double result = 0.0;///
    public void init() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea(clipboard);
//        textField.setLineWrap(true);
//        content.add(textField);
        Font font = new Font ("Consolas", Font.BOLD, 12); // Установить стиль шрифта
        Font font1=new Font("Consolas", Font.BOLD,16);
        textField.setFont(font);
        textField.setBackground(Color.white);
        textField.setEditable (false); // Установить текстовое поле, чтобы не редактировать

        JPanel pan1 = new JPanel (); // Установить макет текстового поля
        pan1.setLayout(new GridLayout(1,1,5,5));
        pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        pan1.add(textField);

        JPanel panBody = new JPanel (); // Добавить кнопку в panBody
        panBody.setLayout(new GridLayout(6,4));

        // Создать рамочное окно
        frame.setLayout (new BorderLayout ()); // Макет
        frame.add(pan1, BorderLayout.NORTH);
        frame.add(panBody,BorderLayout.CENTER);
//        frame.setSize (80, 200); // Размер
//        frame.setLocation (160, 320); // Местоположение
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button_clear       = new MyButton("C",     Color.white,    font1, true,    KeyEvent.VK_CLEAR);
        JButton button_delete      = new MyButton("Delete",Color.white,    font1, true,    KeyEvent.VK_BACK_SPACE);
        JButton button_plus        = new MyButton("+",     Color.white,    font1, false,   KeyEvent.VK_ADD);
        JButton button_minus       = new MyButton("-",     Color.white,    font1, false,   KeyEvent.VK_SUBTRACT);
        JButton button_multiply    = new MyButton("*",     Color.white,    font1, false,   KeyEvent.VK_MULTIPLY);
        JButton button_divide      = new MyButton("/",     Color.white,    font1, false,   KeyEvent.VK_SLASH);
        JButton button_spot        = new MyButton(".",     Color.white,    font1, false,   KeyEvent.VK_PERIOD);
        JButton button_is          = new MyButton("=",     Color.pink,     font1, true,    KeyEvent.VK_EQUALS);
        JButton button_sin         = new MyButton("sin",   Color.white,    font1, false);
        JButton button_cos         = new MyButton("cos",   Color.white,    font1, false);
        JButton button_tan         = new MyButton("tan",   Color.white,    font1, false);
        JButton button_log         = new MyButton("log",   Color.white,    font1, false);
        JButton button_bracket_r   = new MyButton("(",     Color.white,    font1, true);
        JButton button_bracket_l   = new MyButton(")",     Color.white,    font1, true);
        JButton[] button = new MyButton[10];
        for (int i = 0; i < 10; i++) {
            button[i] = new MyButton(""+i, Color.white, font1,  true, i + 48);
        }
        // Схема интерфейса калькулятора
        panBody.add(button_clear);
        panBody.add(button_delete);
        panBody.add(button_bracket_r);
        panBody.add(button_bracket_l);
        panBody.add(button_sin);
        panBody.add(button_cos);
        panBody.add(button_tan);
        panBody.add(button_log);
        panBody.add(button[7]);
        panBody.add(button[8]);
        panBody.add(button[9]);
        panBody.add(button_plus);
        panBody.add(button[4]);
        panBody.add(button[5]);
        panBody.add(button[6]);
        panBody.add(button_minus);
        panBody.add(button[1]);
        panBody.add(button[2]);
        panBody.add(button[3]);
        panBody.add(button_multiply);
        panBody.add(button_divide);
        panBody.add(button[0]);
        panBody.add(button_spot);
        panBody.add(button_is);
        panBody.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

        Editor editor = this;
        button_plus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new PlusCommand(editor));
                    }
                });

        button[1].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executeCommand(new NumberCommand(editor, "1"));
                    }
                });


 /*       ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(editor));
            }
        });
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(editor));
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(editor));
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });
        ctrlPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PlusCommand(editor));
            }
        });*/
    }
/*    private void executeCommand(Command command) {
        if (command.execute()) {
            Command.push(command);
        }*/
        private void executeCommand(Command command) {
            if (command.execute()) {
                Command.push(command.itemCommand);
            }
    }
/*    private void undo() {
        if (Command.isEmpty()) return;

        Command command = Command.pop();
        if (command != null) {
            command.undo();
        }*/
    }
}
