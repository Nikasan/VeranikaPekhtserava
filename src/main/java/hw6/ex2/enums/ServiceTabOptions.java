package hw6.ex2.enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceTabOptions {
    SUPPORT("Support", "https://epam.github.io/JDI/support.html"),
    DATES("Dates", "https://epam.github.io/JDI/dates.html"),
    COMPLEXTABLE("Complex Table", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLETABLE("Simple Table", "https://epam.github.io/JDI/simple-table.html"),
    USERTABLE("User Table", "https://epam.github.io/JDI/user-table.html"),
    TABLESANDPAGES("Table with pages", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENTELEMENTS("Different elements", "https://epam.github.io/JDI/different-elements.html"),
    PERFORMANCE("Performance", "https://epam.github.io/JDI/performance.html");

    public final String name;
    public final String url;

    @Override
    public String toString() {
        return url;
    }

    ServiceTabOptions(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public static List<String> getLinkNames() {
        List<String> container = new ArrayList<String>();
        for (ServiceTabOptions option : values()) {
            container.add(option.name);
        }
        return container;
    }
}
