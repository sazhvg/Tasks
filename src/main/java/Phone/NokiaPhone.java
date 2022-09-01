package Phone;

public class NokiaPhone extends Phone  implements PhoneConnection, PhoneMedia{

    private int videoPermission;
    public NokiaPhone( String name, String model, int storege, int memory, int videoPermission ) {
        super(name, model, storege, memory);
        this.videoPermission = videoPermission;
    }

    public void setVideoPermission(int videoPermission) {
        this.videoPermission = videoPermission;
    }
    public int getVideoPermission() {
        return videoPermission;
    }

     public String call(){
         return "Call from " + getName() + " " + getModel();
     }
     public String sendMessage(){
         return "Message from " + getName() + " " + getModel();
     }
     public String takePhoto(){
         return "Photo from " + getName() + " " + getModel();
     }
     public String shootVideos(){
         return "Videos from " + getName() + " " + getModel();
     }


    public String toString() {
        return "Виробник: " + getName() + "; Модель: " + getModel() + "; Сховище: "+ getStorege() +
                "; ОЗУ: " + getMemory() +  "; Камера: " + getVideoPermission() + ".";
    }
}