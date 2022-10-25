package com.ua.sazhyn.volodymyr;

import com.ua.sazhyn.volodymyr.commands.*;

import javax.inject.Inject;
import java.util.Scanner;


public class Editor {

   static Scanner scanner = new Scanner(System.in);
   @Inject
   private NumberCommand numberCommand;
   @Inject
   private IsCommand isCommand;

    public void init(){

        String str = "";
        do {
            if(NumberCommand.number == ""){
                System.out.println("Введіть ціле число");
                str = scanner.next();
                numberCommand.getNumber(str);
            } else {
                System.out.println("Введіть оператор");
                str = scanner.next();

                isCommand.getIsCommand(str);
            }
        }
        while (!str.equals("="));
        System.out.println(Command.calculate());
    }
}

