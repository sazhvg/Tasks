package com.ua.sazhyn.volodymyr;

import com.ua.sazhyn.volodymyr.commands.editor.Editor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(App.class.getPackageName());
        Editor editor = applicationContext.getBean(Editor.class);
//        Editor editor = new Editor();
        editor.init();
    }

}

/*
• Spring - спроєктуй калькулятор, виокремлюючи кожну операцію в окремий клас,
    та застосуй їх разом у головному класі з використанням шаблону Action.

• Guice – перенеси калькулятор на guice.
}*/
