package ua.pp.voronin.serhii.tommy.systems.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class McClient {

    @Value("${clientTimeout}")
    private int clientTimeout;

    public void interact() {}

}
