package Task_02;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Здравствуйте! Запускаем программу...");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка.");
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> source = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            source.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список " + source);
        logger.log("Просим пользователя ввести входные данные для фильтрации.");
        System.out.print("Введите порог для фильтра: ");
        int treshold = scanner.nextInt();
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filter.filterOut(source));
        logger.log("Завершаем программу...");
    }
}
