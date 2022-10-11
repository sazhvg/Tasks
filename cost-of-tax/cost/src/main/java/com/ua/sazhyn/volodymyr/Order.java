package com.ua.sazhyn.volodymyr;

import java.util.HashSet;

public class Order {
    public static void main(String[] args) {

        Car.getFreeCar().add(new Car("Ford", 4, 400, 15.50));
        Car.getFreeCar().add(new Car("Honda", 4, 250, 12.20));

        Client client = new Client("Петро", 7);

        Calculat.calculatTax(Car.getFreeCar(), client.getGeoPositionClientKm());

    }

}
/*
    Cтвори два maven проєкти:

        одномодульний (по розрахунку вартості поїздок в таксі)
        двомодульний (модуль, що містить класи сутностей; головний клас,
         що розраховує ціни для поточної ситуації)
        Зв'яжи їх разом у другому проєкті, використовуючи фіксовану версію
        першого та гнучку версію другого внутрішнього модулю.*/
