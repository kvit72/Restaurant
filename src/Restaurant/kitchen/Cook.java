package Restaurant.kitchen;

import Restaurant.ConsoleHelper;
import Restaurant.Tablet;
import Restaurant.statistic.StatisticManager;
import Restaurant.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable {
    private final String name;

    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;

        Tablet tablet = order.getTablet();

        ConsoleHelper.writeMessage(name + "Start cooking - " + order);

        int totalCookingTime = order.getTotalCookingTime();
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, totalCookingTime * 60, order.getDishes());
        StatisticManager.getInstance().register(row);

        try {
            Thread.sleep(totalCookingTime * 10);
        } catch (InterruptedException ignored) {
        }

        setChanged();
        notifyObservers(order);
        this.busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
