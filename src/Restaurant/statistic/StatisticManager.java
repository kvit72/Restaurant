package Restaurant.statistic;

import Restaurant.statistic.event.EventDataRow;

public class StatisticManager {
    public void register(EventDataRow data) {

    }

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        return InstanceHolder.statisticManager;
    }

    private static class InstanceHolder {
        private static StatisticManager statisticManager = new StatisticManager();
    }
}
