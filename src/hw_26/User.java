package hw_26;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private Address address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
