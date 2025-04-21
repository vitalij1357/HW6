package DATABASE;

import java.io.IOException;

public class TestsQueryService {
    public static void main(String[] args) throws IOException {
        Database database = Database.getObject();
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findLongestProject(database);
        databaseQueryService.findMaxProjectClient(database);
        databaseQueryService.findMaxSalaryWorker(database);
        databaseQueryService.findYoungestOldestWorkers(database);
        databaseQueryService.printProjectPrice(database);
    }
}
