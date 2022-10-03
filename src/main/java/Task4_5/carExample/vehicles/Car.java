package Task4_5.carExample.vehicles;

import Task4_5.carExample.details.Engine;
import Task4_5.carExample.professions.Driver;

public class Car {
    private String producer;
    private String aClass;
    private double weight;
    private Driver driver;
    private Engine engine;


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void carManagement(String str) {
        switch(str) {
            case "start":
                System.out.println("Поехали");
                break;
            case "stop":
                System.out.println("Останавливаемся");
                break;
            case "turnRightStart":
                System.out.println("Сигнал правого повороту увімкнено");
                System.out.println("Поворот направо");
                break;
            case "turnRightStop":
                System.out.println("Сигнал правого повороту ввімкнено");
                break;
            case "turnLeftStart":
                System.out.println("Сигнал лівого повороту увімкнено");
                System.out.println("Поворот налево");
                break;
            case "turnLeftStop":
                System.out.println("Сигнал лівого повороту ввімкнено");
                break;
            case "headlightsOn":
                System.out.println("Фари увімкнено");
                break;
            case "headlightsOff":
                System.out.println("Фари ввімкнено");
                break;
            case "backlightsOn":
                System.out.println("Підсвітка увімкнено");
                break;
            case "backlightsOff":
                System.out.println("Підсвітка ввімкнено");
                break;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", aClass='" + aClass + '\'' +
                ", weight=" + weight +
                ", driver=" + driver +
                ", engine=" + engine +
                '}';
    }
}

/*
    За потреби проведи рефакторинг та додай новий функціонал:

        • Перероби клас Car, видаливши з нього наявний публічний конструктор. Забезпеч коректне
                функціонування решти коду, ападтувавши його до нових обмежень класу Car

        • Додай можливість машин вмикати/вимикати фари, сигнал поворотів, підсвітки.

        • Фнкціонал відкриття та закриття багажнику.

        • Функціонал перемикання режимів їзди (спорт, міськай)*/
