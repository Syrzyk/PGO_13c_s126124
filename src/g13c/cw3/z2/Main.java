package g13c.cw3.z2;

public class Main {
    public static void main(String[] args) {

        // List of Products
        Products p1 = new Products("Piątnica Jogurt naturalny 150 g", ProductType.Consumable, 1.69,100);
        Products p2 = new Products("Finish All In One Max 100 pc", ProductType.Consumable, 59.99,20);
        Products p3 = new Products("Laptop LENOVO ThinkBook G2 ARE 15.6", ProductType.Electronic, 3499.00,2);
        Products p4 = new Products("Squirell feeder Unicorn", ProductType.Entertainment, 149.59,10);
        Products p5 = new Products("Unicorn", ProductType.Entertainment, 29.99,0);

        // List of customers
        Person client1 = new Person("Jan", "Kowalski",10,100);
        Person client2 = new Person("Pawel", "Nowak",100,0);

        // Making order
        client1.MakeOrder();
        client1.getCurrentShoppingCart().addProduct(p3);
        client1.getCurrentShoppingCart().addProduct(p2);
        client1.getCurrentShoppingCart().addProduct(p4);
        client1.getCurrentShoppingCart().addProduct(p5);
        System.out.println(p3.getPrice()+p2.getPrice());
        System.out.println("Price of product: "+p1.getPrice());
        System.out.println("Price of product in shopping cart: "+ client1.getCurrentShoppingCart().getProduct().getPrice());
        System.out.println(client1.getCurrentShoppingCart().getTotalShoppingCartValue());
        client1.BuyByCash();
    }
}
