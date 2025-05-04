package clientCreator;

import DATABASE.DatabaseInitService;
import util.Client;

import java.sql.SQLException;
import java.util.List;

public class testClientService {
    public static void main(String[] args) throws SQLException {
        ClientService clientService = new ClientService();
        DatabaseInitService databaseInitService = new DatabaseInitService();
//        databaseInitService.initDb();
//        clientService.create("Mark");
//        clientService.deleteById(9);
//     clientService.setName(10,"Igor");
//       clientService.getById(10);
        List<Client> clients = clientService.listAll();
        clients.forEach(System.out::println);


    }
}
