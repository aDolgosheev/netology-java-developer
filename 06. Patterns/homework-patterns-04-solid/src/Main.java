import products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Liskov substitution principle - наследники класса Product полностью играют роль предка
        List<Product> productsInStock = new ArrayList<>(Arrays.asList(new Jeans(), new Lemon(), new Meat(), new MobilePhone(), new Potato(), new Skirt(), new Water()));
        //принцип DRY - вывод списка продуктов на экран выносится в цикл в отдельном методе
        printProductsInStock(productsInStock);
        List<Product> basket = createBasket(productsInStock);
        printProductsInStock(productsInStock);
        printProductsBasket(basket);
        System.out.println("Итоговая стоимость вашей корзины составила: " + totalBasketCost(basket) + " руб.");
    }

    private static void printProductsInStock(List<Product> products) {
        System.out.println("Список доступных товаров в магазине:");
        printProductsList(products);
    }

    private static void printProductsList(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {     // В цикле используется Magic Numbers Principle - за границу цикла берется не какое-то число,
                                                        // а размер списка - т.е. количество типов товаров.
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println();
    }

    private static void printProductsBasket(List<Product> basket) {
        System.out.println("Список товаров в вашей корзине:");
        printProductsList(basket);
    }


    private static List<Product> createBasket(List<Product> productsInStock) {
        List<Product> basket = new ArrayList<>();
        while (true) {
            System.out.print("Введите через пробел номер товара и количество или введите `стоп`: ");
            String input = scanner.nextLine();
            if ("стоп".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int requiredCount = Integer.parseInt(parts[1]);
            if (productNumber < 0 || productNumber >= productsInStock.size()) {
                System.out.println("Неверный номер товара.");
            } else {
                if (productsInStock.get(productNumber).remainingCount(requiredCount)) {
                    basket.add(productsInStock.get(productNumber).createBusketProduct(requiredCount));
                }
            }
        }
        System.out.println();
        return basket;
    }

    private static int totalBasketCost(List<Product> basket) {
        int totalCost = 0;
        for (Product product : basket) {
            totalCost += product.getCount() * product.getPrice();
        }
        return totalCost;
    }

}