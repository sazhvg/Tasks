package structural.bridge;

import structural.bridge.model.Profile;
import structural.bridge.products.PurpleCard;
import structural.bridge.products.RedCard;
import structural.bridge.systems.MasterCard;
import structural.bridge.systems.PaymentSystem;
import structural.bridge.systems.Visa;

import java.util.List;

public class Usage {

    private final PaymentSystem masterCard = new MasterCard();
    private final PaymentSystem visa = new Visa();

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
