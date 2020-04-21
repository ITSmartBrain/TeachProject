package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.contactList.add(new Contact("Ivan", "friend"));
        phoneBook.contactList.add(new Contact("Ivan1", "work"));
        phoneBook.contactList.add(new Contact("Ivan2", "friend"));

        Iterator<Contact> iter= phoneBook.createFriendsIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
