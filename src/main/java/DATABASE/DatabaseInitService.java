package DATABASE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException {
        String filename = "sql/init_db.sql";
        String initDB = String.join("\n", Files.readAllLines(Paths.get(filename)));
        Database database = Database.getObject();
        database.executeUpdate(initDB);
    }
}
