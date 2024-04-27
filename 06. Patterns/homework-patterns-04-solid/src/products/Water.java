package products;

public class Water extends Product implements Food {

    public Water() {
        setName("Вода");
        setPrice(40);
        setCount(100);
    }

    public Water(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Water(requestCount);
    }

    @Override
    public void eat() {
        System.out.println("Воду пьют.");
    }
}
