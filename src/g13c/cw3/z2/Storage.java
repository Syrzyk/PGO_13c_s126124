package g13c.cw3.z2;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private int deliveryTime;
    private ArrayList<Products> products = new ArrayList<>();

    public Storage(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void addProduct(Products product){
        products.add(product);
        product.setStorage(this);
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
