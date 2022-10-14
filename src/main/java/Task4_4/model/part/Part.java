package Task4_4.model.part;

sealed public abstract class Part permits Cube, Sphere, Tetrahedron {

    private static final int LAYER = 30;
    private double density; // густина, в грамах на 1 мм³

    public Part(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getProtectiveLayerThickness(double weightInGrams) {
        double weightInKilograms = weightInGrams / 1000;
//        return weightInKilograms / 30; // Підказка: це є магічною цифрою
        return weightInKilograms / LAYER;
    }

    public static int getBoxSize(Part part){

        int boxSizeRequired = switch (part) {
            case Cube c -> c.getSide();
            case Sphere s -> s.getRadius() * 2;
            case Tetrahedron t -> (int) Math.ceil(t.getSide() / Math.sqrt(2));
        };
        return boxSizeRequired;
    }

    public static int getWeight(Part part){

        int volume = switch (part) {
            case Cube c -> c.getSide() * c.getSide() * c.getSide();
            case Sphere s -> (int) Math.ceil(4d / 3 * Math.PI * s.getRadius() * s.getRadius() * s.getRadius());
            case Tetrahedron t -> (int) Math.ceil(Math.sqrt(2) / 12 * t.getSide() * t.getSide() * t.getSide());
        };
        return (int) Math.ceil(volume * part.getDensity());
    }
}
