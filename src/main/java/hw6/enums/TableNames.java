package hw6.enums;

public enum TableNames {
    ROMAN("Roman"),
    SERGEY_IVAN("Sergey Ivan"),
    VLADZIMIR("Vladzimir"),
    HELEN_BENNETT("Helen Bennett"),
    YOSHI_TANNAMURI("Yoshi Tannamuri"),
    GIOVANNI_ROVELLI("Giovanni Rovelli");

    String username;

    TableNames(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }
}
