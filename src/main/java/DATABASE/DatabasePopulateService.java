package DATABASE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException {
        Database database = Database.getObject();
        String filename = "sql/populate_db.sql";
        String populateDB = String.join("\n",Files.readAllLines(Paths.get(filename)));
        PreparedStatement ps = database.prepareStatement(populateDB);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
