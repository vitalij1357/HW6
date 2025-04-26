package DATABASE;

import util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final  String MAX_SALARY = "sql/find_max_salary_worker.sql";
    private static final String Y_O_WORKERS = "sql/ind_youngest_eldest_workers.sql";
    private static final String M_P_CLIENT = "sql/find_max_projects_client.sql";
    private static final String L_PROJECT = "sql/find_longest_project.sql";
    private static final String P_P_PRICE = "sql/print_project_price.sql";

    public List<MaxSalaryWorker> findMaxSalaryWorker(Database db) throws IOException {
        String readSours = String.join("\n", Files.readAllLines(Paths.get(MAX_SALARY)));
        List<MaxSalaryWorker> result = new ArrayList<>();
        ResultSet resultSet = db.executeQuery(readSours);
        try {
            while (resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setSalary(resultSet.getFloat("SALARY"));
                result.add(maxSalaryWorker);
            }
        } catch (SQLException e) {
           throw new  RuntimeException(e);
        }
        return result;
    }
    public List<YoungestOldestWorkers> findYoungestOldestWorkers(Database db) throws IOException {
        String readSours = String.join("\n", Files.readAllLines(Paths.get(Y_O_WORKERS)));
        ResultSet resultSet = db.executeQuery(readSours);
        List<YoungestOldestWorkers> result = new ArrayList<>();

        try {
            while (resultSet.next()){
                YoungestOldestWorkers youngestOldestWorkers = new YoungestOldestWorkers();
                youngestOldestWorkers.setType(resultSet.getString("TYPE"));
                youngestOldestWorkers.setName(resultSet.getString("NAME"));
                youngestOldestWorkers.setBirthday(LocalDate.parse(resultSet.getString("BIRTHDAY")));
                result.add(youngestOldestWorkers);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<MaxProjectClient> findMaxProjectClient(Database database) throws IOException {
            String readSors = String.join("\n", Files.readAllLines(Paths.get(M_P_CLIENT)));
            ResultSet rs = database.executeQuery(readSors);
            List<MaxProjectClient> result = new ArrayList<>();
        try {
        while (rs.next()) {
            MaxProjectClient maxProjectClient = new MaxProjectClient();
            maxProjectClient.setId(rs.getLong("ID"));
            maxProjectClient.setName(rs.getString("NAME"));
            maxProjectClient.setProjectCount(rs.getLong("PROJECT_COUNT"));
            result.add(maxProjectClient);

        }
          } catch(SQLException e){
              throw new RuntimeException(e);
          }
        return result;
    }
    public List<LongestProject> findLongestProject(Database database) throws IOException {
        String readSorse = String.join("\n", Files.readAllLines(Paths.get(L_PROJECT)));
        ResultSet rs = database.executeQuery(readSorse);
        List<LongestProject> result = new ArrayList<>();
        try {
          while (rs.next()) {
              LongestProject longestProject = new LongestProject();
              longestProject.setId(rs.getLong("ID"));
              longestProject.setClientId(rs.getLong("CLIENT_ID"));
              longestProject.setStartDate(LocalDate.parse(rs.getString("START_DATE")));
              longestProject.setFinishDate(LocalDate.parse(rs.getString("FINISH_DATE")));
              longestProject.setProjectDuration(rs.getLong("PROJECT_DURATION"));
              result.add(longestProject);
          }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<ProjectPrice> printProjectPrice(Database database) throws IOException {
        String readSorse = String.join("\n", Files.readAllLines(Paths.get(P_P_PRICE)));
        ResultSet rs = database.executeQuery(readSorse);
        List<ProjectPrice> result = new ArrayList<>();
        try {
            while (rs.next()) {
                ProjectPrice projectPrice = new ProjectPrice();
                projectPrice.setProjectId(rs.getLong("PROJECT_ID"));
                projectPrice.setStartDate(LocalDate.parse(rs.getString("START_DATE")));
                projectPrice.setFinishDate(LocalDate.parse(rs.getString("FINISH_DATE")));
                projectPrice.setClientName(rs.getString("CLIENT_NAME"));
                projectPrice.setDurationMonth(rs.getLong("DURATION_MONTHS"));
                projectPrice.setProjectP(rs.getFloat("PROJECT_PRICE"));
                result.add(projectPrice);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }
}

