package clientCreator;

import DATABASE.DatabaseInitService;
import util.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceTests {
    public static void main(String[] args) throws SQLException {
        DatabaseInitService databaseInitService = new DatabaseInitService();
        ClientDaoService clientDaoService = new ClientDaoService();
        ClientService clientService = new ClientService(clientDaoService);
        clientService.SetName(21,"Ivan");
        List<Client> clients = clientService.listAll();
        clients.forEach(System.out::println);

    }
}
