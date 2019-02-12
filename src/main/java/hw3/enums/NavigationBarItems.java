package hw3.enums;

public enum NavigationBarItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private static final int size = NavigationBarItems.values().length;

    public final String item;

    NavigationBarItems(String item) {
        this.item = item;
    }
}
