package Restaurant.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    private int totalDuration;
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }


}
