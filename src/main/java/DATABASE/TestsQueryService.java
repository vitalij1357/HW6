package DATABASE;

import prefs.Prefs;
import util.*;

import java.io.IOException;
import java.util.List;

public class TestsQueryService {
    public static void main(String[] args) throws IOException {
        Database database = Database.getObject();
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println("   ***");
        List<MaxSalaryWorker> result = databaseQueryService.findMaxSalaryWorker(database);
        result.forEach(System.out::println);

        System.out.println("   ***");
        List<LongestProject> lp = databaseQueryService.findLongestProject(database);
        lp.forEach(System.out::println);

        System.out.println("   ***");
        List<MaxProjectClient> mpc = databaseQueryService.findMaxProjectClient(database);
        mpc.forEach(System.out::println);

        System.out.println("   ***");
        List<ProjectPrice> pp = databaseQueryService.printProjectPrice(database);
        pp.forEach(System.out::println);

        System.out.println("   ***");
        List<YoungestOldestWorkers> yow = databaseQueryService.findYoungestOldestWorkers(database);
        yow.forEach(System.out::println);
    }
}

