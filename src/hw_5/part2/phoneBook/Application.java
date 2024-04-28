package hw_5.part2.phoneBook;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.addContact(new Record("John Doe", "+187687534"));
        pb.addContact(new Record("John Smith", "+189259812"));
        pb.addContact(new Record("John Smith", "+1892353483"));
        pb.addContact(new Record("Jane Doe", "+4476723212"));

        Record contact = pb.findContact("John Doe");
        if (contact != null) {
            System.out.println("Contact " + contact.getName() + " with number(s) " + contact.getPhoneNumber() + " found");
        }
        else {
            System.out.println("not found");
        }

        List<Record> found = pb.findAllContacts("John Smith");
        if (found != null) {
            System.out.println("Found contact(s) " + found.size() + " records:");
            for (Record r : found){
                System.out.println("Name " + r.getName() + " phone number " + r.getPhoneNumber());
                }
            }
        else
            System.out.println("Contact not found");
        }
    }

