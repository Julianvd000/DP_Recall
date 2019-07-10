package dprecall.DOAimpl;

import dprecall.DAO.studentDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.klas;
import dprecall.entitys.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class studentDAOimpl  extends OracleBaseDao implements studentDAO {
    private static Connection conn;
    private List<student> studenten = new ArrayList<student>();

    public List<student> findAll() throws SQLException{
        List<student> studenten = new ArrayList<student>();
        conn = this.getConnection();

        String sql = "SELECT * FROM STUDENT JOIN KLAS ON KLAS.CODE = STUDENT.KLAS_CODE";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            klas klas = new klas();
            student student = new student();

            student.setId(result.getInt("ID"));
            student.setNaam(result.getString("NAAM"));
            if (result.getDate("GBDATUM") != null){
                student.setGbdatum(result.getDate("GBDATUM"));
            }
            if (result.getString("KLAS_CODE") != null){
                klas.setCode(result.getString("KLAS.CODE"));
                klas.setMentor(result.getString("KLAS.MENTOR"));
                klas.setStartjaar(result.getInt("KLAS.STARTJAAR"));
                student.setKlas_code(klas);
            }
            studenten.add(student);
        }
        conn.close();
        return studenten;
    }

    public student getStudent(String naam)throws SQLException{
        conn = this.getConnection();
        String sql = "SELECT * FROM STUDENT JOIN KLAS ON KLAS.CODE = STUDENT.KLAS_CODE WHERE NAAM = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, naam);
        ResultSet result = statement.executeQuery();
        klas klas = new klas();
        student student = new student();

        while (result.next()) {
            student.setId(result.getInt("ID"));
            student.setNaam(result.getString("NAAM"));
            if (result.getDate("GBDATUM") != null) {
                student.setGbdatum(result.getDate("GBDATUM"));
            }
            if (result.getString("KLAS_CODE") != null) {
                klas.setCode(result.getString("CODE"));
                klas.setMentor(result.getString("MENTOR"));
                klas.setStartjaar(result.getInt("STARTJAAR"));
                student.setKlas_code(klas);
            }
        }
        return student;
    }
    public boolean save(student student) throws SQLException {
        conn = this.getConnection();
        String sql = "INSERT INTO VAK (`NAAM`,`GBDATUM`,`KLAS_CODE`) VALUES (?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, student.getNaam());
        statement.setDate(2, student.getGbdatum());
        statement.setString(3, student.getKlas_code().getCode());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("vak toegevoegd");
            return true;
        }
        conn.close();
        return false;
    }

    public student update(student student) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE STUDENT set NAAM = ?, GBDATUM = ?, KLAS_CODE = ? WHERE ID = ? ";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,student.getNaam());
        statement.setDate(2, student.getGbdatum());
        statement.setString(3, student.getKlas_code().getCode());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("student aangepast");
        }
        conn.close();
        return student;
    }

    public boolean delete(student student) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM STUDENT WHERE ID = ? ";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, student.getId());


        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("student verwijderd");
            return true;
        }
        conn.close();
        return false;
    }
}
