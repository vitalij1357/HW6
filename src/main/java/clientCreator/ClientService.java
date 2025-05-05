package clientCreator;

import util.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private final ClientDaoService dao;

    public ClientService(ClientDaoService dao) {
        this.dao = dao;
    }

    public long create (String name) throws SQLException {
        validateName(name);
        return dao.create(name);
    }
    public String getById(long id) throws SQLException {
        return dao.getById(id);
    }
    public void SetName(long id,String name) throws SQLException {
        validateName(name);
        dao.setName(id, name);
    }
    public void deleteById(long id) throws SQLException {
        dao.deleteById(id);
    }
    public List<Client> listAll() throws SQLException {
        return dao.listAll();
    }
    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cent be null");
        }
        if (name.length() < 2 || name.length() > 100) {
            throw new IllegalArgumentException("name cen be from 3 to 100 symbols");
        }
    }
}
