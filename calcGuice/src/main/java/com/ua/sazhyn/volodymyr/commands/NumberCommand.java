package com.ua.sazhyn.volodymyr.commands;


public class NumberCommand extends Command {

    public static String number = "";
    private String str;

    NumberCommand() {
        this.str = "";
    }

    public void getNumber(String str) {

        if (isDigit(str)){
            NumberCommand.number = str;
            Command.push(str);
        } else if(isDigit(str)) {
            System.out.println("Спробуйте ще раз.");
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}