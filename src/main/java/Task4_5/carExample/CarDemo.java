package Task4_5.carExample;

import Task4_5.carExample.details.Engine;
import Task4_5.carExample.professions.Driver;
import Task4_5.carExample.vehicles.*;

public class CarDemo {
    public static void main(String[] args) {

        Car car = addCar(new Car(), "BMW", "C", 5000,
                new Driver("Иванов В.В.", 50,  30),
                new Engine("60", "BMW"));

        Lorry lorry = addCar(new Lorry(70), "Грузовик", "D", 8000,
                new Driver("Петров В.В.", 45,  20),
                new Engine("30", "LorryEngine"));

        SportCar sportCar = addCar(new SportCar(300), "SportCar", "C", 4000,
                new Driver("Сидоров В.В.", 30,  15),
                new Engine("80", "SportEngine"));

        System.out.println(car);
//        car.carManagement("stop");
        System.out.println(lorry);
        System.out.println(sportCar);
//        sportCar.carManagement("sportModeOff");

    }

    public static <T extends Car> T addCar(T car, String producer, String aClass, double weight, Driver driver, Engine engine) {

        car.setProducer(producer);
        car.setaClass(aClass);
        car.setWeight(weight);
        car.setDriver(driver);
        car.setEngine(engine);

        return car;
    }
}