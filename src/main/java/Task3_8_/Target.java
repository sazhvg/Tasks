package Task3_8_;

public class Target {
    private int qty;
    private  double price;

    Target(int qty, double price){
        this.qty = qty;
        this.price = price;
    }
    Target(int qty){
        this.qty = qty;
    }
    public double getPrice() {
        return price;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
}
