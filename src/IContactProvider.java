import java.util.LinkedList;

public interface IContactProvider {
    LinkedList<Contact> loadContacts();

    void add(Contact contact);

    void remove(int index);

    void update(Contact contact);

    void emptyContacts();

    void saveContacts(LinkedList<Contact> contacts);

    void uploadContact();
}