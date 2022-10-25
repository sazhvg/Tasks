package com.ua.sazhyn.volodymyr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Calculator extends JFrame {

    static JFrame frame = new JFrame("Калькулятор");
    JTextField display = new JTextField("0");
    Font font = new Font("Consolas", Font.BOLD, 40); // Установить стиль шрифта
    Font font1 = new Font("Consolas", Font.BOLD, 20);
 //   Image iconImage = (new ImageIcon("C: \\ Study \\ eclipse-workspace \\ Calculator \\ src \\ Calculator2.png")).GetImage();
 //   ImageIcon iconImage2 = new ImageIcon("C: \\ Study \\ eclipse-workspace \\ Calculator \\ src \\ delete.png");
    actionlistener al = new actionlistener(); // Создать объект слушателя действия слушателя
    // Кнопка калькулятора
    JButton button_clear = new JButton("C");
 //   JButton button_delete = new JButton(iconImage2);
    JButton button_plus = new JButton("+");
    JButton button_minus = new JButton("-");
    JButton button_multiply = new JButton("*");
    JButton button_divide = new JButton("/");
    JButton button_spot = new JButton(".");
    JButton button_is = new JButton("=");
    JButton button_sin = new JButton("sin");
    JButton button_cos = new JButton("cos");
    JButton button_tan = new JButton("tan");
    JButton button_log = new JButton("log");
    JButton button_bracket_r = new JButton("(");
    JButton button_bracket_l = new JButton(")");
    JButton[] button = new JButton[10];

    public Calculator() {
        super();

        // Установить цвет шрифта кнопки и слушателя
        for (int i = 0; i < 10; i++) {
            button[i] = new JButton("" + i);
            button[i].setBackground(Color.white); // Установить цвет кнопки
            button[i].setFont(font1); // Установить шрифт кнопки
            button[i].addActionListener(al); // Зарегистрировать слушателя
        }
        // Установить цвет кнопки
        button_plus.setBackground(Color.white);
        button_is.setBackground(Color.pink);
        button_minus.setBackground(Color.white);
        button_multiply.setBackground(Color.white);
        button_divide.setBackground(Color.white);
        button_spot.setBackground(Color.white);
        button_clear.setBackground(Color.white);
        button_delete.setBackground(Color.white);
        button_sin.setBackground(Color.white);
        button_cos.setBackground(Color.white);
        button_tan.setBackground(Color.white);
        button_log.setBackground(Color.white);
        button_bracket_r.setBackground(Color.white);
        button_bracket_l.setBackground(Color.white);
        // Установить кнопку прозрачной
        button_sin.setOpaque(false);
        button_cos.setOpaque(false);
        button_log.setOpaque(false);
        button_tan.setOpaque(false);
        button_plus.setOpaque(false);
        button_minus.setOpaque(false);
        button_multiply.setOpaque(false);
        button_divide.setOpaque(false);
        button_spot.setOpaque(false);
        // Установить шрифт кнопки
        button_plus.setFont(font1);
        button_is.setFont(font1);
        button_minus.setFont(font1);
        button_multiply.setFont(font1);
        button_divide.setFont(font1);
        button_spot.setFont(font1);
        button_clear.setFont(font1);
        button_delete.setFont(font1);
        button_sin.setFont(font1);
        button_cos.setFont(font1);
        button_tan.setFont(font1);
        button_log.setFont(font1);
        button_bracket_r.setFont(font1);
        button_bracket_l.setFont(font1);

        // Схема интерфейса калькулятора
        frame.setIconImage(iconImage);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(font);
        display.setBackground(Color.white);
        display.setEditable(false); // Установить текстовое поле, чтобы не редактировать

        JPanel pan1 = new JPanel(); // Установить макет текстового поля
        pan1.setLayout(new GridLayout(1, 1, 5, 5));
        pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        pan1.add(display);

        JPanel panBody = new JPanel(); // Добавить кнопку в panBody
        panBody.setLayout(new GridLayout(6, 4));
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


        // Создать рамочное окно
        frame.setLayout(new BorderLayout()); // Макет
        frame.add(pan1, BorderLayout.NORTH);
        frame.add(panBody, BorderLayout.CENTER);
        frame.setSize(480, 380); // Размер
        frame.setLocation(260, 150); // Местоположение
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Зарегистрируем слушателя
        button_plus.addActionListener(al);
        button_minus.addActionListener(al);
        button_multiply.addActionListener(al);
        button_divide.addActionListener(al);
        button_is.addActionListener(al);
        button_spot.addActionListener(al);
        button_clear.addActionListener(al);
        button_delete.addActionListener(al);
        button_sin.addActionListener(al);
        button_cos.addActionListener(al);
        button_tan.addActionListener(al);
        button_log.addActionListener(al);
        button_bracket_r.addActionListener(al);
        button_bracket_l.addActionListener(al);

        // Установить горячую клавишу
        button[0].setMnemonic(KeyEvent.VK_0);
        button[1].setMnemonic(KeyEvent.VK_1);
        button[2].setMnemonic(KeyEvent.VK_2);
        button[3].setMnemonic(KeyEvent.VK_3);
        button[4].setMnemonic(KeyEvent.VK_4);
        button[5].setMnemonic(KeyEvent.VK_5);
        button[6].setMnemonic(KeyEvent.VK_6);
        button[7].setMnemonic(KeyEvent.VK_7);
        button[8].setMnemonic(KeyEvent.VK_8);
        button[9].setMnemonic(KeyEvent.VK_9);
        button_delete.setMnemonic(KeyEvent.VK_BACK_SPACE);
        button_clear.setMnemonic(KeyEvent.VK_CLEAR);
        button_spot.setMnemonic(KeyEvent.VK_PERIOD);
        button_is.setMnemonic(KeyEvent.VK_EQUALS);
        button_plus.setMnemonic(KeyEvent.VK_ADD);
        button_minus.setMnemonic(KeyEvent.VK_SUBTRACT);
        button_multiply.setMnemonic(KeyEvent.VK_MULTIPLY);
        button_divide.setMnemonic(KeyEvent.VK_SLASH);
    }
}


