package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendIterator implements Iterator<Contact> {
    List<Contact> friendList = new ArrayList<>();
    int currentIndex=0;
    public FriendIterator(List<Contact> list){
        for(Contact c : list){
            if (c.type.equals("friend")) {
                friendList.add(c);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex< friendList.size();
    }

    @Override
    public Contact next() {
        return friendList.get(currentIndex++);
    }
}
