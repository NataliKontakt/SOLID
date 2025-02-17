package products;

public class DairyProducts extends Product {
    private String unitsOfMeasurement = "литр";

    public DairyProducts(int id, String name, double price) {
        super(id, name, price);
        this.unitsOfMeasurement = "литр";

    }

    public String getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }


    @Override
    public String toString() {
        return super.toString() + unitsOfMeasurement;
    }
}
