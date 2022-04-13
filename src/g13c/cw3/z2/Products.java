package g13c.cw3.z2;

public class Products {
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;
    private Products nextProduct;
    private Storage storage;


    public Products(String name, ProductType productType, double price, int quantity) {
        this.name = name;
        this.productType = productType;
        setPrice(price);
        this.quantity = quantity;
    }


    public Products getNextProduct() {
        return nextProduct;
    }
    public void setNextProduct(Products nextP) {
        this.nextProduct = nextP;
    }



    public void sell(){
        if (isAvailable()){
            throw new RuntimeException("Product is not available.");
        } else
            quantity--;
    }

    public void IncreaseQuantity(int deliveredQty){
        setQuantity(getQuantity()+deliveredQty);
        //setDeliveryTime(0); // after delivery product is available again
    }


    public int IncreaseQuantity(){return 1;}

    // Getters
    public String getName() {
        return name;
    }
    public ProductType getProductType() {
        return productType;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean isAvailable() {
        return quantity <= 0;
    }

    public int deliveryTime() {
        if (quantity > 0 || storage == null){
            return 0;
        } else
            return storage.getDeliveryTime();
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                ", quantity=" + quantity +
                ", nextProduct=" + nextProduct +
                ", storage=" + storage +
                '}';
    }
}
