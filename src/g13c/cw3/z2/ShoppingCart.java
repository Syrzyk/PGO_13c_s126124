package g13c.cw3.z2;

public class ShoppingCart {
    private static long idCount=0;
    private final long  ID=idCount++;
    private Products product;
    //private ArrayList<Products> products = new ArrayList<>();
    // totalPrice = Product.getQty * Product.getPrice

    public ShoppingCart() {
    }

    public void addProduct(Products p){
        if(this.product == null) {
            this.product = p;
            return;
        }
        Products current = product;
        while (current.getNextProduct() != null)
        {
            current = current.getNextProduct();
        }
        current.setNextProduct(p);
    }

    public double getTotalShoppingCartValue(){
        if(product == null) {
            return 0;
        }
        double result = 0;

        Products current = product;

        while (current.getNextProduct() != null)
        {
            result += current.getPrice();// multiply by qty
            current = current.getNextProduct();
        }
        result += current.getPrice();//multiply by qty
        return result;

    }

    public Products getProduct() {
        return product;
    }
}
