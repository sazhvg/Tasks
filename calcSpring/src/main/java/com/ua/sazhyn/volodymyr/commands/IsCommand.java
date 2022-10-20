package com.ua.sazhyn.volodymyr.commands;

import org.springframework.stereotype.Component;

@Component
public class IsCommand extends Command {
    private String str;

    IsCommand() {
        this.str = "";
    }

    public void getIsCommand(String str){
        if (operatot(str)){
            Command.push(str);
            NumberCommand.number="";
        }
    }
    public boolean operatot(String str){
            switch (str) {
                case "+":
                    return true;
                case "-":
                    return true;
                case "=":
                    return false;
                default:
                    return false;
            }
    }
}

