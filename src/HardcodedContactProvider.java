import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HardcodedContactProvider implements IContactProvider {
    private LinkedList<Contact> contactos = new LinkedList<>();
    private Scanner lee = new Scanner(System.in);
    private Agenda agenda;

    @Override
    public LinkedList<Contact> loadContacts() {
        return contactos;
    }

    @Override
    public void add(Contact contact) {
        contactos.add(contact);
        saveContacts(contactos);
//        contactos.add(contact);
    }

    @Override
    public void remove(int index) {
        contactos.remove(contactos.get(index));
    }

    @Override
    public void update(Contact contact) {
        contactos.remove(contact);
        contactos.add(contact);
//        int number;
//        do {
//            System.out.println("Ahora introduce uno de los siguientes numeros para hacer la accion corespondiente:\n" +
//                    "1 - Modificar nombre\n" +
//                    "2 - Modificar telefono\n" +
//                    "3 - Modificar direccion\n" +
//                    "4 - Modificar email\n" +
//                    "0 - Terminar accion");
//            number = lee.nextInt();
//            switch (number) {
//                case 1:
//                    System.out.println("Escribe el nombre");
//                    agenda.search(index).setName(lee.next());
//                    break;
//                case 2:
//                    System.out.println("Escribe el telefono");
//                    agenda.search(index).setPhoneNumber(lee.next());
//                    break;
//                case 3:
//                    System.out.println("Escribe la direccion");
//                    agenda.search(index).setAddress(lee.next());
//                    break;
//                case 4:
//                    System.out.println("Escribe el correo");
//                    agenda.search(index).setEmail(lee.next());
//                    break;
//            }
//        } while (number != 0);
    }

    @Override
    public void emptyContacts() {
        contactos.removeAll(contactos);
    }

    @Override
    public void saveContacts(LinkedList<Contact> contacts) {
        for (Contact c : contacts) {
            contactos.add(c);
        }
    }

    @Override
    public void uploadContact() {
        Contact contacto = new Contact(0, "Pepe", "123456789", "C/Bonita", "pepe@gmail.com");
        contactos.add(contacto);
        Contact contacto1 = new Contact(1, "Maria", "123456789", "C/Bonita", "pepe@gmail.com");
        contactos.add(contacto1);
        Contact contacto2 = new Contact(2, "Jose", "123456789", "C/Bonita", "pepe@gmail.com");
        contactos.add(contacto2);
        Contact contacto3 = new Contact(3, "Cosmin", "123456789", "C/Bonita", "pepe@gmail.com");
        contactos.add(contacto3);
    }
}