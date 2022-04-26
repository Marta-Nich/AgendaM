import java.util.LinkedList;

public interface IContactProvider {
    LinkedList<Contact> loadContacts();

    void add(Contact contact);

    void remove(int index);

    void update(int index);

    void emptyContacts();

    void saveContacts(LinkedList<Contact> contacts);
    void uploadContact();
}