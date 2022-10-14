package ua.pp.voronin.serhii.tommy.systems.client;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class McClient {

    private VisaClient visaClient;

    @Inject
    public void setVisaClient(VisaClient visaClient) {
        this.visaClient = visaClient;
    }

    private int clientTimeout;

    public void interact() {}

}
