package clientCreator;

import util.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private Connection connection;
    private PreparedStatement readSt;
    public ClientService(){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./DB_HW6");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    long create(String name) throws SQLException {
        try(PreparedStatement createSt = connection.prepareStatement("INSERT INTO client (name) VALUES (?)")) {
            createSt.setString(1, name);
            createSt.executeUpdate();
            if (name.length()<3 || name.length()>100){
                throw new IllegalArgumentException("name length from 2 to 100 symbols");
            }
        }
        readSt = connection.prepareStatement("SELECT max(id) AS maxId FROM client");
        long id;
        try (ResultSet rs = readSt.executeQuery()) {
            rs.next();
             id = rs.getLong("maxID");
            System.out.println(id);
        }
        return id;
    }
    public String getById(long id) throws SQLException {
        readSt = connection.prepareStatement("SELECT name FROM client WHERE id = (?)");
        readSt.setLong(1,id);
        String name;
        try (ResultSet rs = readSt.executeQuery()) {
           if(rs.next()){
               String n = rs.getString("name");
               System.out.println(n);
               return n;
           }
           else {
               throw new IllegalArgumentException("id not exists");
           }
        }
    }
    public void setName(long id, String name) throws SQLException {
       try(PreparedStatement createSt = connection.prepareStatement("UPDATE client SET name = (?) Where id = (?)")) {
           createSt.setString(1, name);
           createSt.setLong(2, id);
           int i = createSt.executeUpdate();
           if (i == 0){
               throw new IllegalArgumentException("client with id - " + id + " not exist");
           }
           if (name.length()<3 || name.length()>100){
               throw new IllegalArgumentException("name length from 2 to 100 symbols");
           }
       }
    }
    public void deleteById(long id) throws SQLException {
           try(PreparedStatement createSt = connection.prepareStatement("DELETE FROM client WHERE id = (?)")){
               createSt.setLong(1, id);
               int i = createSt.executeUpdate();
               if (i == 0){
                   throw new IllegalArgumentException("id not exist");
               }
           }
    }
    public List<Client> listAll() throws SQLException {
        List<Client> result = new ArrayList<>();
        readSt = connection.prepareStatement("SELECT * FROM client");
        ResultSet rs = readSt.executeQuery();
        while (rs.next()){
            Client client = new Client();
            client.setId(rs.getLong("id"));
            client.setName(rs.getString("name"));
            result.add(client);
        }
        return result;
    }
}
