package com.ua.sazhyn.volodymyr;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;

public class App {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}

/*
• Spring - спроєктуй калькулятор, виокремлюючи кожну операцію в окремий клас,
    та застосуй їх разом у головному класі з використанням шаблону Action.

• Guice – перенеси калькулятор на guice.
}*/
