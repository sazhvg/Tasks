package com.ua.sazhyn.volodymyr.commands.editor;

import com.ua.sazhyn.volodymyr.commands.*;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

@Component
public class Editor {

    static Scanner scanner = new Scanner(System.in);

    public void init(){
//    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }

/*
    public void init() {
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
*/

        // Схема интерфейса калькулятора

/*        buttons.add(button[7]);
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
        buttons.add(button[0]);
        buttons.add(button_is);*/
    }


