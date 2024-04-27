public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2); // 3
        int b = calc.minus.apply(1,1); // 0
        //int c = calc.devide.apply(a, b); // Ошибка, т.к. в java нельзя делить на ноль целочисленные значения (a / b) = 3 / 0

        /*
        Способы решения:
        1. Исправить значения так, чтобы переменная 'b' != 0
        2. Изменить тип переменной 'c' на переменную с плавающей точкой. Тип переменных в параметрах также следует имзенить:
               double c = calc.devide.apply((double) a, (double) b);
           Также следует изменить типизирование переменных 'devide' и 'println' в Классе 'Calculator' (также на тип с плавающей точкой)
           В таком случае ответ будет "infinity"
        3. Попытаться поймать ошибку 'ArithmeticException' (ниже будет код с таким вариантом решения).
         */

        try {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }

    }
}
