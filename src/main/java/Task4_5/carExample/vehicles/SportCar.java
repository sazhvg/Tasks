package Task4_5.carExample.vehicles;

public class SportCar extends Car {
    private double speed;

    public SportCar(double speed) {
/*
    public SportCar(String producer, String aClass, double weight, Driver driver, Engine engine, double speed) {
            super(producer, aClass, weight, driver, engine);
*/
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void carManagement(String str) {
        switch (str) {
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
            case "trunkOn":
                System.out.println("Багажник відкрито");
                break;
            case "trunkOff":
                System.out.println("Багажник закрито");
                break;
            case "sportModeOn":
                System.out.println("Режим 'Міський' ввімкнено");
                System.out.println("Режим 'Спорт' увімкнено");
                break;
            case "sportModeOff":
                System.out.println("Режим 'Спорт' ввімкнено");
                System.out.println("Режим 'Міський' увімкнено");
                break;
        }
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                "} " + super.toString();
    }
}