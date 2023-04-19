package Restaurant;

import Restaurant.kitchen.Cook;
import Restaurant.kitchen.Order;
import Restaurant.kitchen.Waiter;
import Restaurant.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>(200);
    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }

        Cook cook1 = new Cook("Dima");
        cook1.setQueue(ORDER_QUEUE);
        Cook cook2 = new Cook("Sasha");
        cook2.setQueue(ORDER_QUEUE);

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        Thread cook11 = new Thread(cook1);
        cook11.start();
        Thread cook22 = new Thread(cook2);
        cook22.start();
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        // Показ статистики
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
