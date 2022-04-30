import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


public class FileContactProvider implements IContactProvider {
    private Scanner lee = new Scanner(System.in);
    private Agenda agenda;

    private void order(LinkedList<Contact> contacts) {
        contacts.sort(Comparator.comparing(contact -> contact.getName()));
    }

    @Override
    public LinkedList<Contact> loadContacts() {
        File file = new File("./resources/contacts.txt");
        LinkedList<Contact> contacts = new LinkedList<>();
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            line = read.readLine();
            while (line != null) {
                String[] partes = line.split(";");
                contacts.add(new Contact(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]));
                line = read.readLine();
            }
            order(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.add(contact);
        order(contacts);
        saveContacts(contacts);

    }

    @Override
    public void remove(int index) {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.remove(contacts.get(index));
        order(contacts);
        saveContacts(contacts);
    }

    @Override
    public void update(Contact contact) {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        saveContacts(contacts);
    }

    @Override
    public void emptyContacts() {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        contacts.clear();
        saveContacts(contacts);
    }

    @Override
    public void saveContacts(LinkedList<Contact> contacts) {
        File file = new File("./resources/contacts.txt");
        int id = 0;
        try (PrintWriter writer = new PrintWriter(file)) {
            // BufferedReader read = new BufferedReader(new FileReader(file));
            for (Contact contact : contacts) {
                //    String line = read.readLine();
                String contacto = id++ + ";" + contact.getName() + ";" + contact.getPhoneNumber() +
                        ";" + contact.getAddress() + ";" + contact.getEmail();
                writer.println(contacto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void uploadContact() {
        LinkedList<Contact> contacts;
        contacts = loadContacts();
        Contact ana = new Contact(0, "Ana", "999888777", "C/ del Grevol");
        contacts.add(ana);
        Contact carlos = new Contact(1, "Pablo", "888777666", null, "pablo@gmail.com");
        contacts.add(carlos);
        Contact eva = new Contact(2, "Maria", "777666555", "C/ Ramon Llul", "maria.eva@gmail.com");
        contacts.add(eva);
        Contact lucas = new Contact(3, "Lucas", "666555444");
        contacts.add(lucas);
        order(contacts);
        saveContacts(contacts);
    }
}