import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private LinkedList<Contact> contacts = new LinkedList<>();
    private IContactProvider provider;

    public Agenda(IContactProvider provider) throws FileNotFoundException {
        this.provider = provider;
        refresh();
    }

    private void refresh() throws FileNotFoundException {
        contacts = provider.loadContacts();
        contacts.sort(Comparator.comparing(contact -> contact.getName()));
    }

    public void add(Contact contact) throws FileNotFoundException {
        provider.add(contact);
        refresh();
    }

    public void remove(int index) throws FileNotFoundException {
        provider.remove(index);
        refresh();
    }

    public void update(Contact contact) throws FileNotFoundException {
        provider.update(contact);
        refresh();
    }

    public Contact retrieve(int index) {
        return contacts.get(index);
    }

    public List<Contact> filter(String filter) {
        return contacts.stream().filter(c -> c.getName().contains(filter) || c.getAddress().contains(filter)
                || c.getEmail().contains(filter) || c.getPhoneNumber().contains(filter)).collect(Collectors.toList());
    }

    public Contact search(int index) {
        return contacts.get(index);
    }

    public void uploadContacts() throws FileNotFoundException {
        provider.uploadContact();
        refresh();
    }

    public void emptyContacts() throws FileNotFoundException {
        provider.emptyContacts();
        refresh();
    }

    @Override
    public String toString() {
        String agendaStr = "";
        for (Contact contact : contacts)
            agendaStr += contacts.indexOf(contact) + "\n" + contact + "\n\n";
        return agendaStr + "\n";
    }
}
/*
public List<Contact> filter(String filter) {
        return contacts.stream().filter(c -> c.getName().contains(filter) || c.getAddress().contains(filter)
                || c.getEmail().contains(filter) || c.getPhoneNumber().contains(filter)).collect(Collectors.toList());
    }
    */