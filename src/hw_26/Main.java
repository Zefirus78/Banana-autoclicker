package hw_26;

public class Main {
    public static void main(String[] args) {
        User user = new User("John", 25);

        Address address = new Address("The United Kingdom", "London", "NW1 6XE", "221B Baker St");
        user.setAddress(address);

        String country = user.getAddress().getCountry();
        String city = user.getAddress().getCity();
        String zip = user.getAddress().getZip();
        String street = user.getAddress().getStreet();

        System.out.println("Country: " + country);
        System.out.println("City: " + city);
        System.out.println("Zip: " + zip);
        System.out.println("Street: " + street);
    }
}
