import products.BakeryProducts;
import products.DairyProducts;
import products.Fruits;
import products.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new DairyProducts(1, "Молоко", 100));
        products.add(new BakeryProducts(2, "Булка", 30));
        products.add(new BakeryProducts(3, "Батон", 40));
        products.add(new DairyProducts(4, "Кефир", 110));
        products.add(new Fruits(5, "Бананы", 200));
        products.add(new Fruits(6, "Апельсины", 190));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
