import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Scanner lee = new Scanner(System.in);

    public static void menuAgenda(Agenda agenda) throws FileNotFoundException {
        int action;
        do {
            System.out.println("Introduce uno de los siguientes numeros para hacer la accion corespondiente:\n" +
                    "1 - Añadir contacto\n" +
                    "2 - Borrar contacto\n" +
                    "3 - Modificar contacto\n" +
                    "4 - Mostrar Contactos\n" +
                    "5 - Cargar contactos\n" +
                    "6 - Vaciar contactos\n" +
                    "0 - Terminar accion");
            action = lee.nextInt();
            switch (action) {
                case 1:
                    String yesNO;
                    do {
                        System.out.println("Introduce uno de los siguientes numeros para hacer la accion corespondiente:\n" +
                                "1 - Crear contacto con: id, nombre y numero de telefono\n" +
                                "2 - Crear contacto con: id, nombre, numero de telefono y direccion\n" +
                                "3 - Crear contacto con: id, nombre, numero de telefono, direccion y email\n" +
                                "4 - Crear contacto con: id, nombre, numero de telefono y email");
                        int addNumber = lee.nextInt();
                        int id;
                        String name;
                        String phoneNumbre;
                        String address;
                        String email;
                        if (addNumber == 1) {
                            id = setId();
                            name = setName();
                            phoneNumbre = setPhoneNamber();
                            Contact contact = new Contact(id, name, phoneNumbre);
                            agenda.add(contact);
                        } else if (addNumber == 2) {
                            id = setId();
                            name = setName();
                            phoneNumbre = setPhoneNamber();
                            address = setAddress();
                            Contact contact = new Contact(id, name, phoneNumbre, address, null);
                            agenda.add(contact);
                        } else if (addNumber == 3) {
                            id = setId();
                            name = setName();
                            phoneNumbre = setPhoneNamber();
                            address = setAddress();
                            email = setEmail();
                            Contact contact = new Contact(id, name, phoneNumbre, address, email);
                            agenda.add(contact);
                        } else if (addNumber == 4) {
                            id = setId();
                            name = setName();
                            phoneNumbre = setPhoneNamber();
                            email = setEmail();
                            Contact contact = new Contact(id, name, phoneNumbre, null, email);
                            agenda.add(contact);
                        }
                        System.out.println("Escribe Y para continuar añadiendo o N para dejar de añadir");
                        yesNO = lee.next().toUpperCase();
                    } while (!yesNO.equals("N"));
                    break;
                case 2:
                    System.out.println("¿Quieres ver los contactos que hay?\n" +
                            "S - Para mostrarlos\n" +
                            "Cualquier caracter para no mostrar los conactos");
                    String yes = lee.next().toUpperCase();
                    if (yes.equals("S")) {
                        System.out.println("Estos son los contactos que puedes borrar");
                        System.out.println(agenda);
                    }
                    System.out.println("Escribe el indice del contacto que quieres borrar");
                    int index = lee.nextInt();
                    agenda.remove(index);
                    break;
                case 3:
                    System.out.println("¿Quieres ver los contactos que hay?\n" +
                            "S - Para mostrarlos\n" +
                            "Cualquier caracter para no mostrar ños contactos");
                    String si = lee.next().toUpperCase();
                    if (si.equals("S")) {
                        System.out.println("Estos son los contactos que puedes borrar\n");
                        System.out.println(agenda);
                    }
                    System.out.print("Escribe el indice del contacto que quieres modificar.\n");
                    int contact = lee.nextInt();
                    agenda.update(contact);
                    break;
                case 4:
                    System.out.println(agenda);
                    break;
                case 5:
                    agenda.uploadContacts();
                    break;
                case 6:
                    agenda.emptyContacts();
                    break;
            }
        } while (action != 0);
    }

    private static String setEmail() {
        String email;
        System.out.println("Escribe el email");
        email = lee.next();
        return email;
    }

    private static String setAddress() {
        String address;
        System.out.println("Escribe la direccion");
        address = lee.next();
        return address;
    }

    private static String setPhoneNamber() {
        String phoneNumbre;
        System.out.println("Escribe el telefono");
        phoneNumbre = lee.next();
        return phoneNumbre;
    }

    private static String setName() {
        String name;
        System.out.println("Escribe el nombre");
        name = lee.next();
        return name;
    }

    private static int setId() {
        int id;
        System.out.println("Escribe el id");
        id = lee.nextInt();
        return id;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        menuAgenda(new Agenda(new HardcodedContactProvider()));
        menuAgenda(new Agenda(new FileContactProvider()));
/*
0;Pepe;123456789;C/Bonita;pepe@gmail.com
1;Maria;123456789;C/Bonita;pepe@gmail.com
*/
    }
}