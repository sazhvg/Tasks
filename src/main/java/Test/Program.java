package Test;

public class Program {
    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);
        sw.addElectricityListener(new ElectricityConsumer() {
            @Override
            public void electricityOn() {
                System.out.println("Пожар");
            }
        });

        sw.addElectricityListener(
            () ->{
                System.out.println("Звонок");
            }
        );

        sw.switchOn();
    }
}
