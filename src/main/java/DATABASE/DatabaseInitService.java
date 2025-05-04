package DATABASE;

import org.flywaydb.core.Flyway;
import prefs.Prefs;

public class DatabaseInitService {
   private static final String CONNECT_URL = new Prefs().getString("DBurl");
    public  void initDb() {
        Flyway flyWay = Flyway.configure().
                dataSource(CONNECT_URL, null, null).
                load();
        flyWay.migrate();


    }
}
