package ua.pp.voronin.serhii.tommy;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import ua.pp.voronin.serhii.tommy.service.ConfigurationService;
import ua.pp.voronin.serhii.tommy.systems.MasterCard;
import ua.pp.voronin.serhii.tommy.systems.PaymentSystem;
import ua.pp.voronin.serhii.tommy.systems.Visa;
import ua.pp.voronin.serhii.tommy.systems.client.McClient;
import ua.pp.voronin.serhii.tommy.systems.client.VisaClient;

import javax.inject.Singleton;

public class MainModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(PaymentSystem.class).annotatedWith(Names.named("masterCard"))
                .to(MasterCard.class).asEagerSingleton();
        binder.bind(PaymentSystem.class).annotatedWith(Names.named("visa"))
                .to(Visa.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    public VisaClient provideVisaClient(ConfigurationService configurationService,
            McClient mcClient) {
        VisaClient visaClient = new VisaClient();
        visaClient.setClientTimeout(configurationService.getClientTimeoutFromSomeRemoteSource());
        visaClient.setMcClient(mcClient);
        return visaClient;
    }
}
