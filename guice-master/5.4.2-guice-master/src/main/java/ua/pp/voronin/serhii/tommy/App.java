package ua.pp.voronin.serhii.tommy;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule());

        Usage usage = injector.getInstance(Usage.class);
        usage.createTestProfiles();
    }
}
