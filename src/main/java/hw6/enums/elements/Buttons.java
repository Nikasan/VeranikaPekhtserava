package hw6.enums.elements;

public enum Buttons {

    DAFAULT_BUTTON("Default Button"),
    BUTTON("Button");

    private final String value;

    Buttons(String value){this.value = value;}

    @Override
    public String toString(){return value;}

}
