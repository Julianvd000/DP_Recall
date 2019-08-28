package dprecall.DOAimpl;

import dprecall.DAO.studentDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import static org.osgi.util.measurement.Unit.s;


public class studentDAOimpl extends OracleBaseDao implements studentDAO {
    public ArrayList<Student> findAll() throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Student> list = new ArrayList<Student>();

        String queryText = "SELECT * FROM student join klas on klas.code = student.klas_code ";
        ResultSet rs = stmt.executeQuery(queryText);

        while(rs.next()) {
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            Date gbdatum = rs.getDate("gbdatum");
            Klas newklas = new Klas(rs.getString("klas_code"), rs.getString("Mentor"),rs.getInt("Startjaar"));
            Student s = new Student(id, naam, gbdatum, newklas);
            list.add(s);
        }

        rs.close();
        stmt.close();


        return list;
    }

    public Student findByID(int id) throws SQLException {
        Connection conn = getConnection();
        String queryText2 = "SELECT * FROM student join klas on klas.code = student.klas_code  WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText2);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        int leerlingid = rs.getInt("id");
        String naam = rs.getString("naam");
        Date gbdatum = rs.getDate("gbdatum");
        String klascode = rs.getString("klas_code");

        Klas newklas = new Klas(rs.getString("klas_code"), rs.getString("Mentor"),rs.getInt("Startjaar"));
        Student s = new Student(id, naam, gbdatum, newklas);

        rs.close();
        pstmt.close();

        return s;
    }

        public ArrayList<Student> findStudentenByKlas(Klas klas) throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Student> list = new ArrayList<Student>();

        String queryText = "SELECT * FROM student join klas on klas.code = student.klas_code WHERE klas_code = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, klas.getKlascode());
        ResultSet rs = pstmt.executeQuery(queryText);

        while(rs.next()) {
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            Date gbdatum = rs.getDate("gbdatum");

            Klas newklas = new Klas(rs.getString("code"), rs.getString("Mentor"),rs.getInt("Startjaar"));
            Student s = new Student(id, naam, gbdatum, newklas);
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
        pstmt.setInt(1, student.getId());
        pstmt.setString(2, student.getNaam());
        pstmt.setDate(3, (java.sql.Date) student.getGbdatum());
        pstmt.setString(4, student.getKlas().getKlascode());
        pstmt.executeUpdate();

        pstmt.close();


        return student;
    }
    public int findIdByObj(Student s) {
        Connection conn = getConnection();
        int id = 0;
        try {
            String query1 = "SELECT * FROM STUDENT WHERE NAAM = ? AND GBDATUM = ? AND KLAS_CODE = ?";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setString(1, s.getNaam());
            pstmt1.setDate(2, (java.sql.Date) s.getGbdatum());
            pstmt1.setString(3, s.getKlas().getKlascode());
            ResultSet rs = pstmt1.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return id;
    }
    public Student StudentVolgtVak(Student student, Vak vak) throws SQLException {
        Connection conn = getConnection();

        String queryText = "INSERT INTO VOLGT VALUES (?,?)";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setInt(1, student.getId());
        pstmt.setString(2, vak.getCode());
        pstmt.executeUpdate();

        pstmt.close();


        return student;
    }

    public Student update(Student student) throws SQLException {
        Connection conn = getConnection();

        String queryText = "UPDATE student SET naam=?, gbdatum=?, klas_code=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, student.getNaam());
        pstmt.setDate(2, (java.sql.Date) student.getGbdatum());
        pstmt.setString(3, student.getKlas().getKlascode());
        pstmt.setInt(4, student.getId());
        pstmt.executeUpdate();

        pstmt.close();


        return student;
    }

    public boolean delete(Student student) {
        Connection conn = getConnection();
        String query = "DELETE FROM VOLGT WHERE STUDENT_ID = ?";
        String query2 = "DELETE FROM STUDENT WHERE ID = ?";

        // dit checkt of het object een geldig ID heeft en haalt deze wanneer nodig op uit de database
        int id = 0;
        if (student.getId() == 0) {
            id = findIdByObj(student);
        } else {
            id = student.getId();
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setInt(1, id);
            pstmt2.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
    public ArrayList<Vak> krijgAlleVakken(Student student){
        ArrayList<Vak> vakken = new ArrayList<Vak>();
        Connection conn = getConnection();
        try {
        PreparedStatement prepStatement = conn.prepareStatement("SELECT VAK.* FROM VAK INNER JOIN VOLGT on VAK.CODE = VOLGT.VAK_CODE WHERE VOLGT.STUDENT_ID =? ");
        prepStatement.setInt(1, student.getId());
        ResultSet result = prepStatement.executeQuery();
        while (result.next()){
            Vak newvak = new Vak(result.getString("Code"), result.getString("NAAM"), result.getInt("ECTS"));
            vakken.add(newvak);
        }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return vakken;
    }
}


