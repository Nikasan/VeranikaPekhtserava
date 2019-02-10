package hw4.Enums.differentElementsPage;

public enum ButtonsEnum {
    SUBMITBUTTON(0),
    BUTTON(1);

    public int index;

    ButtonsEnum(int index) {
        this.index = index;
    }
    // TODO Please try to find out how improve it
    public static String getTextValue(int index) {
        switch (index) {
            case 0:
                return "Button";
            case 1:
                return "Default button";
            default:
                return null;
        }
    }
}
