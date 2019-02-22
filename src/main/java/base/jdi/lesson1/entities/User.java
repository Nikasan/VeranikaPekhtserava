package base.jdi.lesson1.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    public static  User PETER = new User ("epam","1234","PITER CHAILOVSKII");
    String login;
    String password;
    String fullName;

//    public User(String login, String password) {
//        this.login = login;
//        this.password = password;
//        this.fullName = fullName;
//
//    }



}
