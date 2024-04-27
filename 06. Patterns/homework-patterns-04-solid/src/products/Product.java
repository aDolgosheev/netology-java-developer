package products;

public abstract class Product {
    private String name;
    private int price;
    private int count;

    public Product() {
    }

    public Product(int count) {
        this();
        this.count = count;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
    }

    public boolean remainingCount(int requestCount) {
        if (count >= requestCount) {
            count -= requestCount;
            return true;
        } else {
            System.out.println("Такого количества товара нет в наличии.");
            return false;
        }
    }

    public void addProduct(int addCount) {
        count += addCount;
        System.out.println("В магазин привезли товар: " + name + " в количестве: " + addCount + " единиц.");
    }

    @Override
    public String toString() {
        return "Наименование товара: " + name + "; цена, за единицу товара: " + price + " руб.; Единиц товара: " + count + ".";
    }

    public abstract Product createBusketProduct(int requestCount);
}
