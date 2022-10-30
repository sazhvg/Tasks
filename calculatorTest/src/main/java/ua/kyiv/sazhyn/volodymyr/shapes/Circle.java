package ua.kyiv.sazhyn.volodymyr.shapes;

public class Circle extends Shape{
    private int radius;

    public Circle(int radius) {
        if (radius <= 0){
            throw new IllegalStateException("Radius has to be positive");
        }
        this.radius = radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0){
            throw new IllegalStateException("Radius has to be positive");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "коло";
    }

    public int getRadius() {
        return radius;
    }
}
