1. Принцип избегания магических чисел

Магические числа заменены константами или понятными значениями:

1.1. В репозитории продуктов (ProductRepository), единицы измерения для каждого типа продукта задаются в
классах-наследниках (DairyProducts, BakeryProducts, Fruits), а не прописываются явно.

https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/BakeryProducts.java#L8
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/DairyProducts.java#L8
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/Fruits.java#L8

1.2. Методы работают с параметрами, например, addProduct(Product product) принимает объект продукта, вместо того чтобы в
коде захардкодить идентификаторы или другие значения.

https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L13-L18

2. Принцип DRY (Don't Repeat Yourself)

2.1. Логика для всех товаров (ID, название, цена) находится в базовом классе Product. Она используется повторно в
наследниках.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/Product.java#L4-L6

2.2. Методы для работы с корзиной (Cart) и для управления продуктами (ProductRepository) абстрагированы — они работают
универсально с объектами Product и его наследниками.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L21-L23
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L16-L17

2.3. Метод showCart() в классе Cart обрабатывает корзину независимо от типа продукта.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/Cart.java#L10-L12

3. Принципы SOLID

3.1. S — Single Responsibility (Принцип единственной ответственности)

3.1.1. Product хранит данные о продукте.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/Product.java#L8-L12

3.1.2. DairyProducts, BakeryProducts, Fruits добавляют единицы измерения для соответствующих групп продуктов.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/BakeryProducts.java#L8
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/DairyProducts.java#L8
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/Fruits.java#L8

3.1.3. ProductRepository управляет данными о продуктах.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L21-L27

3.1.4. Cart управляет корзиной.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/Cart.java#L18-L33

3.2. O — Open/Closed Principle (Принцип открытости/закрытости)

Программа может быть расширена без изменения существующего кода:

3.2.1. Добавление новых категорий продуктов возможно путем создания новых дочерних классов от Product (например, для
овощей или напитков).
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/products/Fruits.java#L3-L19

3.2.2. Логика Cart и ProductRepository уже поддерживает работу с любым типом Product без изменений.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L16-L17

3.3. L — Liskov Substitution Principle (Принцип подстановки Барбары Лисков)
Объекты базового класса Product могут быть заменены объектами его наследников без изменения корректности программы:
Везде, где используется Product (например, в Cart или ProductRepository), можно безопасно использовать DairyProducts,
BakeryProducts или Fruits.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L21-L23
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/ProductRepository.java#L16-L17

3.4. D — Dependency Inversion Principle (Принцип инверсии зависимостей)

Высокоуровневые модули не зависят от низкоуровневых, а обе группы зависят от абстракций:
В Main используется Cart, который можно легко заменить или модифицировать, например, добавить очистку корзины.
https://github.com/NataliKontakt/SOLID/blob/b464c147ee9f7cf9d1e2b7fe5485fb977a8bc63b/src/Cart.java#L14-L16
