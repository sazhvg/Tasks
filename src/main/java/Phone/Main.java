package Phone;

public class Main {
    public static void main(String[] args) {

        Phone phone = new NokiaPhone("Nokia", "S-Class", 10000, 4096, 1980000);
        System.out.println(phone);
        System.out.println( phone.call());
        System.out.println( phone.sendMessage());
        System.out.println( phone.takePhoto());
        System.out.println( phone.shootVideos());

        phone = new SamsungPhone("Samsung", "A-Class", 5000, 2048);
        System.out.println(phone);
        System.out.println( phone.call());
        System.out.println( phone.sendMessage());
        System.out.println( phone.takePhoto());
        System.out.println( phone.shootVideos());
    }
}
