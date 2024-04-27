package products;

public class Potato extends Product implements Food {


    public Potato() {
        setName("Картофель");
        setPrice(30);
        setCount(50);
    }

    public Potato(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Potato(requestCount);
    }

    @Override
    public void eat() {
        System.out.println("Картофель едят.");
    }
}
