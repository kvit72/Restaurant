package Restaurant.ad;

public class AdvertisementStorage {
    private static class InstanceHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanceHolder.ourInstance;
    }

    private AdvertisementStorage() {

    }
}
