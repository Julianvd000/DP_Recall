package dprecall;

import java.sql.*;

abstract public class OracleBaseDao {
    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
    private static final String DB_USER = "JULIAN_2";
    private static final String DB_PASS = "root";

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
