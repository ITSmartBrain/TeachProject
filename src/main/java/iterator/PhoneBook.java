package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Социальная сеть
 */

public class PhoneBook {
    List<Contact> contactList = new ArrayList<>();


    public Iterator<Contact> createFriendsIterator() {
        return new FriendIterator(contactList);
    }


    public Iterator<Contact> createFamilyIterator() {
        return null;
    }
}

