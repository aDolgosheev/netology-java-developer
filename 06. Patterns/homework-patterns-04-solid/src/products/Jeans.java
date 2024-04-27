package products;

public class Jeans extends Product implements Clothes {

    // Open Closed Principle - имплементируя интерфейс Clothes мы добавляем
    // классу функциональности, не изменяя его код

    // Single Responsibility Principle - класс Jeans описывает только джинсы, а не все товары

    public Jeans() {
        setName("Джинсы");
        setPrice(1200);
        setCount(5);
    }

    public Jeans(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Jeans(requestCount);
    }

    @Override
    public void putOn() {
        System.out.println("Джинсы можно надеть");
    }
}
