package dprecall.DOAimpl;

import dprecall.DAO.klasDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class klasDAOimpl extends OracleBaseDao implements klasDAO {
    public ArrayList<Klas> findAll() throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Klas> list = new ArrayList<Klas>();

        String queryText = "SELECT * FROM klas";
        ResultSet rs = stmt.executeQuery(queryText);

        while(rs.next()) {
            String code = rs.getString("code");
            String mentor = rs.getString("mentor");
            int startjaar = rs.getInt("startjaar");

            Klas k = new Klas(code, mentor, startjaar);

            list.add(k);
        }

        rs.close();
        stmt.close();


        return list;
    }
    public Klas findByCode(String code) throws SQLException {
        Connection conn = getConnection();
        String queryText2 = "SELECT * FROM klas WHERE code = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText2);
        pstmt.setString(1, code);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        String klascode = rs.getString("code");
        String mentor = rs.getString("mentor");
        int startjaar = rs.getInt("startjaar");

        Klas k = new Klas(klascode, mentor, startjaar);

        rs.close();
        pstmt.close();

        return k;
    }

    public ArrayList<Klas> findKlassenByMentor(String mentor) throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Klas> list = new ArrayList<Klas>();

        String queryText = "SELECT * FROM klas WHERE mentor = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, mentor);
        ResultSet rs = pstmt.executeQuery(queryText);

        while(rs.next()) {
            Klas k = new Klas(rs.getString("code"), rs.getString("mentor"), rs.getInt("startjaar"));
            list.add(k);
        }

        rs.close();
        stmt.close();


        return list;
    }

    public Klas save(Klas klas) throws SQLException {
        Connection conn = getConnection();

        String queryText = "INSERT INTO klas VALUES (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, klas.getKlascode());
        pstmt.setString(2, klas.getMentor());
        pstmt.setInt(3, klas.getStartjaar());
        pstmt.executeUpdate();

        pstmt.close();


        return klas;
    }

    public Klas update(Klas klas) throws SQLException {
        Connection conn = getConnection();

        String queryText = "UPDATE klas SET mentor=?, startjaar=? WHERE code=?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, klas.getMentor());
        pstmt.setInt(2, klas.getStartjaar());
        pstmt.setString(3, klas.getKlascode());
        pstmt.executeUpdate();

        pstmt.close();


        return klas;
    }
    public ArrayList<Student> getAllStudenten(Klas klas){
        ArrayList<Student> Studenten = new ArrayList<Student>();
        Connection conn = getConnection();
        try {
            PreparedStatement prepStatement = conn.prepareStatement("SELECT STUDENT.*,KLAS.* FROM STUDENT join KLAS on STUDENT.KLAS_CODE= KLAS.CODE WHERE STUDENT.KLAS_CODE = ? ");
            prepStatement.setString(1, klas.getKlascode());
            ResultSet result = prepStatement.executeQuery();
            while (result.next()){
                Klas newklas = new Klas(result.getString("CODE"),result.getString("MENTOR"), result.getInt("STARTJAAR"));
                Student newstudent = new Student(result.getInt("ID"), result.getString("NAAM"), result.getDate("GBDATUM"), newklas);
                Studenten.add(newstudent);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Studenten;
    }
    public boolean delete(Klas klas) {
        try {
            Connection conn = getConnection();

            String queryText = "DELETE FROM klas WHERE code = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryText);
            pstmt.setString(1, klas.getKlascode());
            pstmt.executeUpdate();

            pstmt.close();


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
