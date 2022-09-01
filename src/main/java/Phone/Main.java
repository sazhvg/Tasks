package Phone;

public class Main {
    public static void main(String[] args) {

        NokiaPhone nokiaPhone = new NokiaPhone("Nokia", "S-Class", 10000, 4096, 1980000);
        System.out.println(nokiaPhone);
        System.out.println(nokiaPhone.call());
        System.out.println(nokiaPhone.sendMessage());
        System.out.println(nokiaPhone.call());
        System.out.println(nokiaPhone.sendMessage());


        SamsungPhone samsungPhone = new SamsungPhone("Samsung", "A-Class", 5000, 2048);
        System.out.println(samsungPhone);
        System.out.println(samsungPhone.call());
        System.out.println(samsungPhone.sendMessage());

    }
}