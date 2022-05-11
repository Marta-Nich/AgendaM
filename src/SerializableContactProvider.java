import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


public class SerializableContactProvider implements IContactProvider {
    private Scanner lee = new Scanner(System.in);
    private Agenda agenda;

    private void order(LinkedList<Contact> contacts) {
        contacts.sort(Comparator.comparing(contact -> contact.getName()));
    }

    @Override
    public LinkedList<Contact> loadContacts() throws LoadContactsException {
        File file = new File("./resources/contactosSerializados.obj");
        LinkedList<Contact> contacts = new LinkedList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file.getAbsoluteFile()))) {
            while (true) {
                contacts.add((Contact) inputStream.readObject());
            }
        } catch (EOFException ignored) {

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void add(Contact contact) throws LoadContactsException {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.add(contact);
        order(contacts);
        saveContacts(contacts);

    }

    @Override
    public void remove(int index) throws LoadContactsException {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.remove(contacts.get(index));
        order(contacts);
        saveContacts(contacts);
    }

    @Override
    public void update(Contact contact) throws LoadContactsException {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        saveContacts(contacts);
    }

    @Override
    public void emptyContacts() throws LoadContactsException {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.clear();
        saveContacts(contacts);
    }

    @Override
    public void saveContacts(LinkedList<Contact> contacts) {
        File file = new File("./resources/contactosSerializados.obj");
        int id = 0;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Contact contact : contacts) {
                objectOutputStream.writeObject(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadContact() throws LoadContactsException {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        Contact ana = new Contact(0, "Ana", "999888777", "C/ del Grevol", null);
        contacts.add(ana);
        Contact carlos = new Contact(1, "Pablo", "888777666", null, "pablo@gmail.com");
        contacts.add(carlos);
        Contact eva = new Contact(2, "Maria", "777666555", "C/ Ramon Llul", "maria.eva@gmail.com");
        contacts.add(eva);
        Contact lucas = new Contact(3, "Lucas", "666555444", null, null);
        contacts.add(lucas);
        order(contacts);
        saveContacts(contacts);
    }
}