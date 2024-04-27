package products;

public class Lemon extends Product implements Food, Fruit {

    // Interface Segregation Principle - применяем разные интерфейсы вместо одного общего

    // Dependency Inversion Principle - используется зависимость от абстракций (Food, Fruit), а не от имплементации,
    // мы можем поменять один интерфейс на другой без сложностей

    public Lemon() {
        setName("Лимон");
        setPrice(120);
        setCount(80);
    }

    public Lemon(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Lemon(requestCount);
    }

    @Override
    public void eat() {
        System.out.println("Лимон едят.");
    }

    @Override
    public boolean isFruit() {
        System.out.println("Лимон является фруктом.");
        return true;
    }
}
