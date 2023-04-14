package Restaurant;

import Restaurant.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Dima");
        tablet.addObserver(cook);

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
