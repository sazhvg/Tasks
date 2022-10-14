package ua.pp.voronin.serhii.tommy.systems.client;

public class VisaClient {

    private McClient mcClient;

    public void setMcClient(McClient mcClient) {
        this.mcClient = mcClient;
    }

    private int clientTimeout;

    public void interactWithVisa() {}

    public void setClientTimeout(int clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

}
