package base.Enums;

public enum BenefitsTextList {
    FIRST_ICON_TEXT("To include good practices\nand ideas from successful\nEPAM project"),
    SECOND_ICON_TEXT("To be flexible and\ncustomizable"),
    THIRD_ICON_TEXT("To be multiplatform"),
    FOURTH_ICON_TEXT("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
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
