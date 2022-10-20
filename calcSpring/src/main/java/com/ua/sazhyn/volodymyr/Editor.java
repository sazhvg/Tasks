package com.ua.sazhyn.volodymyr;

import com.ua.sazhyn.volodymyr.commands.Command;
import com.ua.sazhyn.volodymyr.commands.IsCommand;
import com.ua.sazhyn.volodymyr.commands.NumberCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@PropertySource("application.yaml")
public class Editor {

   static Scanner scanner = new Scanner(System.in);
   @Autowired
   private NumberCommand numberCommand;
   @Autowired
   private IsCommand isCommand;
   @Value("${numberA}")
   private String a; // для випробування, в розрахунках не використовується.

    public void init(){

        System.out.println(a);
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

