package hw6.enums;

public enum NavigationBarItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    public final String item;

    NavigationBarItems(String item) {
        this.item = item;
    }
}
