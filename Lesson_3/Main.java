import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//2. Создать массив из 5 товаров.
//Пример:
// вначале объявляем массив объектов
//Product[] productsArray = new Product[5];
        Product[] productsArray = new Product[5];
// потом для каждой ячейки массива задаем объект
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024", "Apple Inc.", "USA", 1299.00, false);
        productsArray[2] = new Product("LG OLED65C4", "28.03.2024", "LG Electronics", "South Korea", 1799.99, true);
        productsArray[3] = new Product("Dell XPS 15", "10.07.2024", "Dell Inc.", "USA", 1499.00, false);
        productsArray[4] = new Product("Bosch KGN392IDF", "05.05.2024", "Bosch", "Germany", 899.00, true);
        System.out.println(Arrays.toString(productsArray));
    }

}
