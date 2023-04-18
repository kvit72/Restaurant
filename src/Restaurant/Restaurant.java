package Restaurant;

import Restaurant.kitchen.Cook;
import Restaurant.kitchen.Waiter;
import Restaurant.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }

        Cook cook1 = new Cook("Dima");
        Cook cook2 = new Cook("Dima");

        StatisticManager.getInstance().register(cook1);
        StatisticManager.getInstance().register(cook2);

        for (Tablet tablet :
                tablets) {
            tablet.addObserver(cook1);
            tablet.addObserver(cook2);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
