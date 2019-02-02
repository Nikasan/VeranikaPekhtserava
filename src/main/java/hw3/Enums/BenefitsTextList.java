package hw3.Enums;

public enum BenefitsTextList {
    FIRST_TEXT_UNDER_ICONS("To include good practices\nand ideas from successful\nEPAM project"),
    SECOND_TEXT_UNDER_ICONS("To be flexible and\ncustomizable"),
    THIRD_TEXT_UNDER_ICONS("To be multiplatform"),
    FOURTH_TEXT_UNDER_ICONS("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    private String value;

    BenefitsTextList(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
