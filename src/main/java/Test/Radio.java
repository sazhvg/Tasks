package Test;

public class Radio implements ElectricityConsumer{
    public void playMusic (){
        System.out.println("Музіка");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}
