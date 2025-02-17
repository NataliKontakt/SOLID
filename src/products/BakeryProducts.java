package products;

public class BakeryProducts extends Product {
    private final String unitsOfMeasurement;

    public BakeryProducts(int id, String name, double price) {
        super(id, name, price);
        this.unitsOfMeasurement = "штука";
    }

    @Override
    public String toString() {
        return super.toString() + unitsOfMeasurement;
    }

    public String getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }
}
