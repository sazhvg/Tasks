package Task4_4.model.packaging;

public class Box {

    private int side; // в міліметрах

    public Box(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public static int calculateBoxPrice(Box box, int pricePerMeter) {
        int boxSize = box.getSide();
        int boxArea = 6 * boxSize * boxSize ; // площа поверхні куба в мм²
        double pricePerMilimeter = pricePerMeter / 1000d / 1000d;
        return (int) Math.ceil(boxArea * pricePerMilimeter);
    }

    @Override
    public String toString() {
        return "ящик {" + side + '*' + side + '*' + side + '}';
    }
}
