package com.ua.sazhyn.volodymyr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(com.ua.sazhyn.volodymyr.App.class.getPackageName());
        Editor editor = applicationContext.getBean(Editor.class);
        editor.init();
    }

}

/*
• Spring - спроєктуй калькулятор, виокремлюючи кожну операцію в окремий клас,
    та застосуй їх разом у головному класі з використанням шаблону Action.

• Guice – перенеси калькулятор на guice.
}*/
