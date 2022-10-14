package ua.pp.voronin.serhii.tommy;

import ua.pp.voronin.serhii.tommy.model.Profile;
import ua.pp.voronin.serhii.tommy.products.PurpleCard;
import ua.pp.voronin.serhii.tommy.products.RedCard;
import ua.pp.voronin.serhii.tommy.systems.PaymentSystem;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class Usage {

    @Inject @Named("masterCard")
    private PaymentSystem masterCard;
    @Inject @Named("visa")
    private PaymentSystem visa;

    public List<Profile> createTestProfiles() {
        return List.of(
            new Profile(
                    "Alice",
                    "Some",
                    List.of(new RedCard("Зарплатна", visa), new PurpleCard("Для виплат", visa))),
            new Profile(
                    "Bob",
                    "Another",
                    List.of(new PurpleCard("Зарплатна", masterCard), new RedCard("Для виплат", visa))),
            new Profile(
                    "Charlie",
                    "Yet",
                    List.of(new RedCard("Зарплатна", masterCard), new PurpleCard("Для виплат", masterCard)))
        );
    }
}
