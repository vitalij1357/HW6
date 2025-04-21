package DATABASE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabaseQueryService {
    private static final  String MAX_SALARY = "sql/find_max_salary_worker.sql";
    private static final String Y_O_WORKERS = "sql/ind_youngest_eldest_workers.sql";
    private static final String M_P_CLIENT = "sql/find_max_projects_client.sql";
    private static final String L_PROJECT = "sql/find_longest_project.sql";
    private static final String P_P_PRICE = "sql/print_project_price.sql";

    public void findMaxSalaryWorker(Database db) throws IOException {
        String readSours = String.join("\n", Files.readAllLines(Paths.get(MAX_SALARY)));
        ResultSet resultSet = db.executeQuery(readSours);
        try {
            while (resultSet.next()) {
                float salary = resultSet.getFloat("salary");
                System.out.println("salary: " + salary);
            }
        } catch (SQLException e) {
           throw new  RuntimeException(e);
        }
    }
    public void findYoungestOldestWorkers(Database db) throws IOException {
        String readSours = String.join("\n", Files.readAllLines(Paths.get(Y_O_WORKERS)));
        ResultSet resultSet = db.executeQuery(readSours);

        try {
            while (resultSet.next()){
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                LocalDate birthday = LocalDate.parse(resultSet.getString("BIRTHDAY"));

                System.out.println("type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Birthday: " + birthday);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void findMaxProjectClient(Database database) throws IOException {
            String readSors = String.join("\n", Files.readAllLines(Paths.get(M_P_CLIENT)));
            ResultSet rs = database.executeQuery(readSors);
        try {
        while (rs.next()) {
            long id = rs.getLong("ID");
            String name = rs.getString("NAME");
            long projectCount = rs.getLong("PROJECT_COUNT");

            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("PROJECT NAME: " + projectCount);
        }
          } catch(SQLException e){
              throw new RuntimeException(e);
          }
    }
    public void findLongestProject(Database database) throws IOException {
        String readSorse = String.join("\n", Files.readAllLines(Paths.get(L_PROJECT)));
        ResultSet rs = database.executeQuery(readSorse);
        try {
          while (rs.next()) {
              long id = rs.getLong("ID");
              long Cid = rs.getLong("CLIENT_ID");
              LocalDate startDate = LocalDate.parse(rs.getString("START_DATE"));
              LocalDate finishDate = LocalDate.parse(rs.getString("FINISH_DATE"));
              long projectDuration = rs.getLong("PROJECT_DURATION");

              System.out.println("ID: " + id);
              System.out.println("ClientID: " + Cid);
              System.out.println("Start Date: " + startDate);
              System.out.println("Finish Date: " + finishDate);
              System.out.println("Project Duration: " + projectDuration);
          }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void printProjectPrice(Database database) throws IOException {
        String readSorse = String.join("\n", Files.readAllLines(Paths.get(P_P_PRICE)));
        ResultSet rs = database.executeQuery(readSorse);
        try {
            while (rs.next()) {
                long projectId = rs.getLong("PROJECT_ID");
                LocalDate startDate = LocalDate.parse(rs.getString("START_DATE"));
                LocalDate finishDate = LocalDate.parse(rs.getString("FINISH_DATE"));
                String clientName = rs.getString("CLIENT_NAME");
                long durationMonths = rs.getLong("DURATION_MONTHS");
                float projectPrice = rs.getFloat("PROJECT_PRICE");

                System.out.println("Project ID: " + projectId);
                System.out.println("Start Date: " + startDate);
                System.out.println("Finish Date: " + finishDate);
                System.out.println("Client Name: " + clientName);
                System.out.println("Duration Months: " + durationMonths);
                System.out.println("PROJECT PRICE: " + projectPrice);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
