package base.jdi.enums;

public enum Odds {
    ONE (1),
    THREE(3),
    FIVE(5),
    SEVEN(7);

    public final int odds;
    Odds(int odds) {
        this.odds = odds;
    }
}
