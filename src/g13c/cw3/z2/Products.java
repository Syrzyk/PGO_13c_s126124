package g13c.cw3.z2;

public class Products {
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;
    private boolean isAvailable;
    private Products nextProduct;



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



    public void Sell(){
        if (!isAvailable){
            throw new RuntimeException("Product is not available.");
        } else
            quantity--;


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
        return isAvailable;
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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
