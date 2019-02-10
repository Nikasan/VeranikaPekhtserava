package hw4.Enums.differentElementsPage;
// TODO please check package name with Java Code Convention

public enum RadioButtonEnum {
    GOLD(0),
    SILVER(1),
    BRONZE(2),
    SELEN(3);

    public int index;

    RadioButtonEnum(int index) {
        this.index = index;
    }
    // TODO Please try to find out how improve it
    public static String getTextValue(int index) {
        switch (index) {
            case 0:
                return "Gold";
            case 1:
                return "Silver";
            case 2:
                return "Bronze";
            case 3:
                return "Selen";
            default:
                return null;
        }
    }
}
