package b12.Java_Collection_Framework.bai_tap.Framework;

public class Product {
    private int id;
    private String nameProduct;
    private String brand;
    private int price;

    public Product() {
    }

    public Product(int id, String nameProduct, String brand, int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price;
    }
}
