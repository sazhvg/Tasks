package ua.pp.voronin.serhii.tommy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.pp.voronin.serhii.tommy.service.ConfigurationService;
import ua.pp.voronin.serhii.tommy.systems.client.VisaClient;

@Configuration
@PropertySource("application.yaml")
public class BeanConfiguration {

    @Bean
    public VisaClient visaClient(ConfigurationService configurationService) {
        VisaClient visaClient = new VisaClient();
        visaClient.setClientTimeout(configurationService.getClientTimeoutFromSomeRemoteSource());
        return visaClient;
    }
}
