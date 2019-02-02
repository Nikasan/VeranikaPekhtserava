package hw3.Enums;

public enum User {
    USER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String name;

    User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
