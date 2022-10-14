package ua.pp.voronin.serhii.tommy.service;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationService {

    public int getClientTimeoutFromSomeRemoteSource() {
        return 12345;
    }
}
