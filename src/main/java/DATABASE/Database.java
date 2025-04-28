package DATABASE;


import prefs.Prefs;

import java.sql.*;

public class Database {
    private static final Database OBJECT = new Database();
    private  Connection connection;

    private Database() {
        String dBurl = new Prefs().getString("DBurl");
        try {
            connection = DriverManager.getConnection(dBurl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getObject(){
        return OBJECT;
    }

    public Connection getConnection(){
        return connection;
    }

    public ResultSet executeQuery(String sql){
        try {
           Statement st = connection.createStatement();
            return  st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public PreparedStatement prepareStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int executeUpdate (String sql){
        try {
            Statement st = connection.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
