package ua.pp.voronin.serhii.tommy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(App.class.getPackageName());
        Usage usage = applicationContext.getBean(Usage.class);
        usage.createTestProfiles();
    }
}
