package hw_26;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private String country;
    private String city;
    private String zip;
    private String street;

    public Address(String country, String city, String zip, String street) {
        this.country = country;
        this.city = city;
        this.zip = zip;
        this.street = street;
    }
}
