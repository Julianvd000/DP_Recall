package dprecall.DOAimpl;

import dprecall.DAO.studentDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class studentDAOimpl extends OracleBaseDao implements studentDAO {
    public ArrayList<Student> findAll() throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Student> list = new ArrayList<Student>();

        String queryText = "SELECT * FROM student";
        ResultSet rs = stmt.executeQuery(queryText);

        while(rs.next()) {
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            Date gbdatum = rs.getDate("gbdatum");
            String klascode = rs.getString("klas_code");

            Student s = new Student(id, naam, gbdatum, klascode);

            list.add(s);
        }

        rs.close();
        stmt.close();


        return list;
    }

    public Student findByID(int id) throws SQLException {
        Connection conn = getConnection();
        String queryText2 = "SELECT * FROM student WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText2);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        int leerlingid = rs.getInt("id");
        String naam = rs.getString("naam");
        Date gbdatum = rs.getDate("gbdatum");
        String klascode = rs.getString("klas_code");

        Student s = new Student(leerlingid, naam, gbdatum, klascode);

        rs.close();
        pstmt.close();

        return s;
    }

    public ArrayList<Student> findStudentenByKlas(String klas) throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Student> list = new ArrayList<Student>();

        String queryText = "SELECT * FROM student WHERE klas_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, klas);
        ResultSet rs = pstmt.executeQuery(queryText);

        while(rs.next()) {
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            Date gbdatum = rs.getDate("gbdatum");
            String klascode = rs.getString("klas_code");

            Student s = new Student(id, naam, gbdatum, klascode);

            list.add(s);
        }

        rs.close();
        stmt.close();


        return list;
    }

    public Student save(Student student) throws SQLException {
        Connection conn = getConnection();

        String queryText = "INSERT INTO student VALUES (?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setInt(1, student.getID());
        pstmt.setString(2, student.getNaam());
        pstmt.setDate(3, (java.sql.Date) student.getGBdatum());
        pstmt.setString(4, student.getKlasCode());
        pstmt.executeUpdate();

        pstmt.close();


        return student;
    }

    public Student update(Student student) throws SQLException {
        Connection conn = getConnection();

        String queryText = "UPDATE student SET naam=?, gbdatum=?, klas_code=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, student.getNaam());
        pstmt.setDate(2, (java.sql.Date) student.getGBdatum());
        pstmt.setString(3, student.getKlasCode());
        pstmt.setInt(4, student.getID());
        pstmt.executeUpdate();

        pstmt.close();


        return student;
    }

    public boolean delete(Student student) {
        try {
            Connection conn = getConnection();

            String queryText = "DELETE FROM student WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryText);
            pstmt.setInt(1, student.getID());
            pstmt.executeUpdate();

            pstmt.close();


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


