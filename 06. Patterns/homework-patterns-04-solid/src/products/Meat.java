package products;

public class Meat extends Product implements Food {

    public Meat() {
        setName("Мясо");
        setPrice(300);
        setCount(15);
    }

    public Meat(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Meat(requestCount);
    }

    @Override
    public void eat() {
        System.out.println("Мясо едят.");
    }
}
