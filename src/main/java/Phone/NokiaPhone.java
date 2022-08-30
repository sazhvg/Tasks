package Phone;

public class NokiaPhone extends Phone  implements PhoneConnection, PhoneMedia{

    private int videoPermission;
    NokiaPhone( String name, String model, int storege, int memory, int videoPermission ) {
        super(name, model, storege, memory);
        this.videoPermission = videoPermission;
    }

    public void setVideoPermission(int videoPermission) {
        this.videoPermission = videoPermission;
    }
    public int getVideoPermission() {
        return videoPermission;
    }

    public String toString() {
        return "Виробник: " + getName() + "; Модель: " + getModel() + "; Сховище: "+ getStorege() +
                "; ОЗУ: " + getMemory() +  "; Камера: " + getVideoPermission() + ".";
    }
}