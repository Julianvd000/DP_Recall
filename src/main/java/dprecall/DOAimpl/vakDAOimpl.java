package dprecall.DOAimpl;

import dprecall.DAO.vakDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class vakDAOimpl extends OracleBaseDao implements vakDAO {

    public ArrayList<Vak> findAll() throws SQLException {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Vak> list = new ArrayList<Vak>();

        String queryText = "SELECT * FROM vak";
        ResultSet rs = stmt.executeQuery(queryText);

        while(rs.next()) {
            String code = rs.getString("code");
            String naam = rs.getString("naam");
            int ects = rs.getInt("ects");

            Vak v = new Vak(code, naam, ects);

            list.add(v);
        }

        rs.close();
        stmt.close();


        return list;
    }

    public Vak findByCode(String code) throws SQLException {
        Connection conn = getConnection();
        String queryText2 = "SELECT * FROM vak WHERE code = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryText2);
        pstmt.setString(1, code);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        String vakcode = rs.getString("code");
        String naam = rs.getString("naam");
        int ects = rs.getInt("ects");

        Vak v = new Vak(vakcode, naam, ects);

        rs.close();
        pstmt.close();

        return v;
    }

    public Vak save(Vak vak) throws SQLException {
        Connection conn = getConnection();

        String queryText = "INSERT INTO vak VALUES (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, vak.getCode());
        pstmt.setString(2, vak.getNaam());
        pstmt.setInt(3, vak.getECTS());
        pstmt.executeUpdate();

        pstmt.close();


        return vak;
    }


    public Vak update(Vak vak) throws SQLException {
        Connection conn = getConnection();

        String queryText = "UPDATE vak SET naam=?, ects=? WHERE code=?";
        PreparedStatement pstmt = conn.prepareStatement(queryText);
        pstmt.setString(1, vak.getNaam());
        pstmt.setInt(2, vak.getECTS());
        pstmt.setString(3, vak.getCode());
        pstmt.executeUpdate();

        pstmt.close();


        return vak;
    }
    public ArrayList<Student> krijgAlleStudenten(Vak vak){
        ArrayList<Student> Studenten = new ArrayList<Student>();
        Connection conn = getConnection();
        try {
            PreparedStatement prepStatement = conn.prepareStatement("SELECT Student.*, Klas.* FROM Student INNER JOIN VOLGT on Student.id = VOLGT.STUDENT_ID JOIN KLas on Klas.CODE = STUDENT.KLAS_CODE WHERE VOLGT.VAK_CODE = ? ");
            prepStatement.setString(1, vak.getCode());
            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()){
                Klas newklas = new Klas(rs.getString("code"), rs.getString("Mentor"),rs.getInt("Startjaar"));
                Student s = new Student(rs.getInt("id"), rs.getString("naam"), rs.getDate("gbdatum"), newklas);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Studenten;
    }
    public boolean delete(Vak vak) {
        try {
            Connection conn = getConnection();

            String queryText = "DELETE FROM vak WHERE code = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryText);
            pstmt.setString(1, vak.getCode());
            pstmt.executeUpdate();

            pstmt.close();


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}