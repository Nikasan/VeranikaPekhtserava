package hw6.ex3.enums.elements;

public enum CheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public final String checkBox;

    CheckBoxes(String checkBox) {
        this.checkBox = checkBox;
    }
}