package g13c.cw3.z2;

import java.util.ArrayList;

public class Person {
    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyInCard;
    private ShoppingCart currentShoppingCart;
    private final ArrayList<ShoppingCart> historyShoppingCart = new ArrayList<>();

    // Constructors
    public Person(String name, String surname, double moneyInCash, double moneyInCard) {
        this.name = name;
        this.surname = surname;
        this.moneyInCash = moneyInCash;
        this.moneyInCard = moneyInCard;
    }

    // Methods


    public ShoppingCart getCurrentShoppingCart() {
        return currentShoppingCart;
    }

    public void MakeOrder(){
        if (this.currentShoppingCart != null ) {
            throw new RuntimeException("You have already placed an order. You can add more products to your order.");
            }

        this.currentShoppingCart = new ShoppingCart();

    }

    public double ShoppingCartValue(ShoppingCart shopCart){
        return currentShoppingCart.getTotalShoppingCartValue();
    }

    public void buyByCash(){
        if (getMoneyInCash() < this.currentShoppingCart.getTotalShoppingCartValue()){
            throw new RuntimeException("Unable to complete transaction. Please use another form of payment.");
        }


        historyShoppingCart.add(currentShoppingCart);
        currentShoppingCart=null;
        }
        // transaction, odlaczanie wagonikow i odejmowanie qty z dostepnych produktow



    public void buyByCard(){
        if (getMoneyInCard() < this.currentShoppingCart.getTotalShoppingCartValue()){
            throw new RuntimeException("Unable to complete transaction. Please use another form of payment.");
        }

        setMoneyInCard(getMoneyInCard()- currentShoppingCart.getTotalShoppingCartValue());
        System.out.println("Value of purchase is: "+ currentShoppingCart.getTotalShoppingCartValue()+" dollars. On your card is now "+ getMoneyInCard() + "dollars");
        currentShoppingCart.sell();
        historyShoppingCart.add(currentShoppingCart);
        currentShoppingCart=null;

    }

    // Getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public double getMoneyInCash() {
        return moneyInCash;
    }
    public double getMoneyInCard() {
        return moneyInCard;
    }

    public ArrayList<ShoppingCart> getHistoryShoppingCart() {
        return historyShoppingCart;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new RuntimeException("Surname cannot be empty");
        }
        this.surname = surname;
    }

    public void setMoneyInCash(double moneyInCash) {
        this.moneyInCash = moneyInCash;
    }

    public void setMoneyInCard(double moneyInCard) {
        this.moneyInCard = moneyInCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "historyShoppingCart=" + historyShoppingCart +
                '}';
    }
}
