package hw_5.part2.phoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Record> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Record r) {
        this.contacts.add(r);
    }

    public Record findContact(String name){
        for(Record r : contacts){
            if(r.getName().equals(name)){
                return r;
            }
        }
        return null;
    }

    public List<Record> findAllContacts(String name){
        List<Record> allContactsByName = new ArrayList<>();
        for(Record r : contacts){
            if(r.getName().equals(name)){
                allContactsByName.add(r);
            }
        }
        return allContactsByName.isEmpty() ? null : allContactsByName;
    }


}
