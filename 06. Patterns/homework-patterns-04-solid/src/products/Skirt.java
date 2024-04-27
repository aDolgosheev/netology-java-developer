package products;

public class Skirt extends Product implements Clothes {

    public Skirt() {
        setName("Юбка");
        setPrice(500);
        setCount(8);
    }

    public Skirt(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new Skirt(requestCount);
    }

    @Override
    public void putOn() {
        System.out.println("Юбку можно надеть");
    }
}
