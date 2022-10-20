package com.ua.sazhyn.volodymyr;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule());
        Editor editor = injector.getInstance(Editor.class);
        editor.init();
    }
}

/*
• Spring - спроєктуй калькулятор, виокремлюючи кожну операцію в окремий клас,
    та застосуй їх разом у головному класі з використанням шаблону Action.

• Guice – перенеси калькулятор на guice.
}*/
