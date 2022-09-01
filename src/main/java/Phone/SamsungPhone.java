package Phone;

public class SamsungPhone extends Phone implements PhoneConnection{

    SamsungPhone( String name, String model, int storege, int memory) {
        super(name, model, storege, memory);
    }


    public String call(){
         return "Call from " + getName() + " " + getModel();
     }
     public String sendMessage(){
         return "Message from " + getName() + " " + getModel();
     }
}
