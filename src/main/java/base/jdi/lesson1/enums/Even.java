package base.jdi.lesson1.enums;

public enum Even {
    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8);
    public final int even;
    Even(int even) {
        this.even = even;
    }
}
