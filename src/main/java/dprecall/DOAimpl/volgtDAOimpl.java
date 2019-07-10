package dprecall.DOAimpl;

import dprecall.DAO.volgtDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.klas;
import dprecall.entitys.student;
import dprecall.entitys.vak;
import dprecall.entitys.volgt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class volgtDAOimpl  extends OracleBaseDao implements volgtDAO {
    private static Connection conn;
    private List<student> studenten = new ArrayList<student>();

    public List<volgt> findAll() throws SQLException {
        List<volgt> studenten = new ArrayList<volgt>();
        conn = this.getConnection();

        String sql = "SELECT * FROM VOLGT JOIN VAK on VOLGT.VAK_CODE = VAK.CODE JOIN STUDENT ON VOLGT.STUDENT_ID = STUDENT.ID JOIN KLAS ON KLAS.CODE = STUDENT.KLAS_CODE";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            klas klas = new klas();
            student student = new student();
            vak vak = new vak();
            volgt volgt = new volgt();

            student.setId(result.getInt("STUDENT.ID"));
            student.setNaam(result.getString("STUDENT.NAAM"));
            if (result.getDate("STUDENT.GBDATUM") != null){
                student.setGbdatum(result.getDate("STUDENT.GBDATUM"));
            }
            if (result.getString("STUDENT.KLAS_CODE") != null){
                klas.setCode(result.getString("KLAS.CODE"));
                klas.setMentor(result.getString("KLAS.MENTOR"));
                klas.setStartjaar(result.getInt("KLAS.STARTJAAR"));
                student.setKlas_code(klas);
            }

            volgt.setStudent(student);
            vak.setCode(result.getString("VAK.CODE"));
            vak.setNaam(result.getString("VAK.NAAM"));
            vak.setECTS(result.getInt("VAK.ECTS"));

            volgt.setVak(vak);
            studenten.add(volgt);
        }
        return studenten;
    }

    public List<volgt> findbyStudent(student studentin) throws SQLException {
        List<volgt> studenten = new ArrayList<volgt>();
        conn = this.getConnection();

        String sql = "SELECT STUDENT_ID, VAK_CODE, VAK.NAAM, VAK.ECTS, STUDENT.NAAM, STUDENT.GBDATUM, KLAS_CODE, KLAS.MENTOR, KLAS.STARTJAAR FROM VOLGT JOIN VAK on VOLGT.VAK_CODE = VAK.CODE JOIN STUDENT ON VOLGT.STUDENT_ID = STUDENT.ID JOIN KLAS ON KLAS.CODE = STUDENT.KLAS_CODE WHERE STUDENT_ID =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, studentin.getId());
        ResultSet result = statement.executeQuery();

        while (result.next()){
            klas klas = new klas();
            student student = new student();
            vak vak = new vak();
            volgt volgt = new volgt();

            student.setId(result.getInt("STUDENT_ID"));
            student.setNaam(result.getString("NAAM"));
            if (result.getDate("GBDATUM") != null){
                student.setGbdatum(result.getDate("GBDATUM"));
            }
            if (result.getString("KLAS_CODE") != null){
                klas.setCode(result.getString("KLAS_CODE"));
                klas.setMentor(result.getString("MENTOR"));
                klas.setStartjaar(result.getInt("STARTJAAR"));
                student.setKlas_code(klas);
            }

            volgt.setStudent(student);
            vak.setCode(result.getString("VAK_CODE"));
            vak.setNaam(result.getString("NAAM"));
            vak.setECTS(result.getInt("ECTS"));

            volgt.setVak(vak);
            studenten.add(volgt);
        }
        return studenten;
    }
    public boolean save(vak vak, student student) throws SQLException{
        String sql = "INSERT INTO VAK (`STUDENT_ID`,`VAK_CODE`) VALUES (?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, student.getId());
        statement.setString(2, vak.getCode());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("vak toegevoegd");
            return true;
        }
        conn.close();
        return false;
    }
}
