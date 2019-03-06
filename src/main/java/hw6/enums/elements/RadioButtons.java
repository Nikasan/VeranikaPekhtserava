package hw6.enums.elements;

public enum RadioButtons {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public final String radioButton;

    RadioButtons(String radioButton) {
        this.radioButton = radioButton;
    }

    @Override
    public String toString() {
        return radioButton;
    }
    }
