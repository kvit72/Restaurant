package Restaurant.ad;

public class Advertisement {
    // видео
    private Object content;

    private String name;

    // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private long initialAmount;

    // количество оплаченых показов
    private int hits;

    // продолжительность в секундах
    private int duration;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }
}
