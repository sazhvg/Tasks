package Phone;

public class Main {
    public static void main(String[] args) {

        Phone phone = new NokiaPhone("Nokia", "S-Class", 10000, 4096, 1980000);
        System.out.println(phone);
        Class[] interfaces = phone.getClass().getInterfaces();

        for (Class i : interfaces) {
            if (i.getSimpleName().equals("PhoneConnection")) {
                System.out.println(phone.call());
                System.out.println(phone.sendMessage());
            }
            if (i.getSimpleName().equals("PhoneMedia")) {
                System.out.println(phone.call());
                System.out.println(phone.sendMessage());
            }
        }

        phone = new SamsungPhone("Samsung", "A-Class", 5000, 2048);
        System.out.println(phone);
        interfaces = phone.getClass().getInterfaces();
        for (Class i : interfaces) {
            if (i.getSimpleName().equals("PhoneConnection")) {
                System.out.println(phone.call());
                System.out.println(phone.sendMessage());
            }
            if (i.getSimpleName().equals("PhoneMedia")) {
                System.out.println(phone.call());
                System.out.println(phone.sendMessage());

            }
        }
    }
}