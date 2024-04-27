package products;

public class MobilePhone extends Product {

    public MobilePhone() {
        setName("Телефон");
        setPrice(15000);
        setCount(2);
    }

    public MobilePhone(int count) {
        this();
        setCount(count);
    }

    @Override
    public Product createBusketProduct(int requestCount) {
        return new MobilePhone(requestCount);
    }
}
