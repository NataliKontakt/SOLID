import products.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }
    //Очистка корзины - не используется, для иллюстрации Dependency Inversion Principle
    public void clearCart() {
        items.clear();
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Ваша корзина пуста.");
            return;
        }
        System.out.println("Ваша корзина:");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double cost = product.getPrice() * quantity;
            total += cost;
            System.out.printf("- %s x%d = %.2f руб.%n", product.getName(), quantity, cost);
        }
        System.out.printf("Итого: %.2f руб.%n", total);
    }

}
