import java.io.*;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonDataProvider implements IContactProvider {
    private Scanner lee = new Scanner(System.in);
    private Agenda agenda;
    private Gson gson = new Gson();

    private void order(LinkedList<Contact> contacts) {
        contacts.sort(Comparator.comparing(contact -> contact.getName()));
    }


    @Override
    public LinkedList<Contact> loadContacts() throws LoadContactsException {
        File file = new File("./resources/contactosGson.json");
        LinkedList<Contact> contacts = new LinkedList<>();
        try (FileReader reader = new FileReader(file.getAbsoluteFile())) {
            Type list = new TypeToken<List<Contact>>() {
            }.getType();
            contacts = gson.fromJson(reader, list);
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
        } catch (IOException e) {
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
        File file = new File("./resources/contactosGson.json");
        int id = 0;
        String contGson;
        try (FileWriter writer = new FileWriter(file)) {
            contGson = gson.toJson(contacts);
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
