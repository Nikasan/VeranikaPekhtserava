package hw4.Enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceTabOptions {
    SUPPORT("Support", "https://epam.github.io/JDI/support.html"),
    DATES("Dates", "https://epam.github.io/JDI/dates.html"),
    // TODO Please check enum code style
    COMPLEXTABLE("Complex Table", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLETBLE("Simple Table", "https://epam.github.io/JDI/simple-table.html"),
    USER_TABLE("User Table", "https://epam.github.io/JDI/user-table.html"),
    TABLESANDPAGES("Table with pages", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENTELEMENTS("Different elements", "https://epam.github.io/JDI/different-elements.html"),
    PERFORMANCE("Performance", "https://epam.github.io/JDI/performance.html");

    public String name;

    public String getUrl() {
        return url;
    }

    public String url;

    ServiceTabOptions(String name, String url) {
        this.name = name;
        this.url = url;
    }
// TODO Extra empty line
// TODO Extra empty line

    public static List<String> getLinkNames() {
        List<String> container = new ArrayList<>();
        for (ServiceTabOptions option : values()) {
            container.add(option.name);
        }
        return container;
    }
}
