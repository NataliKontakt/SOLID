package products;

public class Fruits extends Product {
    private final String unitsOfMeasurement;

    public Fruits(int id, String name, double price) {
        super(id, name, price);
        this.unitsOfMeasurement = "килограмм";
    }

    @Override
    public String toString() {
        return super.toString() + unitsOfMeasurement;
    }

    public String getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }
}
