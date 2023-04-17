package Restaurant.ad;

import Restaurant.ConsoleHelper;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        };
    }
}
