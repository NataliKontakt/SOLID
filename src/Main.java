import products.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository repository = new ProductRepository();
        Cart cart = new Cart();

        System.out.println("Добро пожаловать в магазин!");

        while (true) {
            System.out.println();
            System.out.println("Выберите опцию: ");
            System.out.println("1. Посмотреть товары");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Посмотреть корзину");
            System.out.println("4. Выйти");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Доступные товары:");
                    repository.getAllProducts().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Введите ID товара: ");
                    int productId = scanner.nextInt();
                    System.out.print("Введите количество: ");
                    int quantity = scanner.nextInt();
                    Product product = repository.getProductById(productId);
                    if (product != null) {
                        cart.addProduct(product, quantity);
                        System.out.println("Товар добавлен в корзину.");
                    } else {
                        System.out.println("Товар не найден.");
                    }
                }
                case 3 -> cart.showCart();
                case 4 -> {
                    System.out.println("Спасибо за покупки! До свидания!");
                    return;
                }
                default -> System.out.println("Неверная опция. Попробуйте снова.");
            }
        }
    }
}