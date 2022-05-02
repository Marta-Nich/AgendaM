import java.util.LinkedList;

public interface IContactProvider {
    LinkedList<Contact> loadContacts() throws LoadContactsException;

    void add(Contact contact) throws LoadContactsException;

    void remove(int index) throws LoadContactsException;

    void update(Contact contact) throws LoadContactsException;

    void emptyContacts() throws LoadContactsException;

    void saveContacts(LinkedList<Contact> contacts);

    void uploadContact() throws LoadContactsException;
}