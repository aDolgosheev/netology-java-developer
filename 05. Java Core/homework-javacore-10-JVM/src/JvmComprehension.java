
public class JvmComprehension {
    // Класс JvmComprehension отдается для загрузки в систему ClassLoader'ов
    // и перемещается в Metaspace для сохранения данных о классе JvmComprehension.
    public static void main(String[] args) {
        // В момент вызова метода main создается фрейм в Stack'е.
        int i = 1;                      // 1 Во фрейме main создается переменная i со значением 1.
        Object o = new Object();        // 2 В Куче создается объект Object и во фрейме main создается переменная o,
                                        // которой присваивается ссылка на этот объект
        Integer ii = 2;                 // 3 В Куче создается объект Integer со значением 2,
                                        // а во фрейме main появляется переменная ii со ссылкой на этот объект
        printAll(o, i, ii);             // 4 В Stack'е создается фрейм printAll
                                        // и в нем записываются переменные Object o, int i и Integer ii
        System.out.println("finished"); // 7 В Stack'е создается фрейм println,
                                        // которому передается ссылка на созданный в Куче объект String со значением "finished".
                                        // В ходе работы программы отрабатывает Garbage Collector.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В Куче создается объект Integer со значением 700,
                                                    // а во фрейме printAll появляется переменная uselessVar
                                                    // со ссылкой на этот объект.
        System.out.println(o.toString() + i + ii);  // 6 В Stack'е создается фрейм println,
                                                    // куда передаются ссылки на Object o, int i и Integer ii.
                                                    // В Stack'е созается фрейм toString.
    }
}