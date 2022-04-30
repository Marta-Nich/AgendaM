import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PostgreSQLProvider implements IContactProvider {
    Connection con = null;

    public PostgreSQLProvider() {
        try {
            String url = "jdbc:postgresql://89.36.214.106:5432/geo_1cfsy_6960g";
            String usuari = "geo_1cfsy_6960g";
            String password = "geo_1cfsy_6960g";
            con = DriverManager.getConnection(url, usuari, password);
            String sql = "create table if not exists Agenda(" +
                    "id SERIAL primary key," +
                    "name varchar(100)," +
                    "phoneNumber varchar(20)," +
                    "adress varchar(100) ," +
                    "email varchar(50))";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<Contact> loadContacts() {
        return null;
    }

    @Override
    public void add(Contact contact) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void emptyContacts() {

    }

    @Override
    public void saveContacts(LinkedList<Contact> contacts) {

    }

    @Override
    public void uploadContact() {

    }
}
//create table Agenda if not exists agenda
/*create table Agenda if not exists (
id SERIAL primary key,
name varchar(100),
phoneNumber varchar(20),
adress varchar(100) ,
email varchar(50))*/
/*
* set*/