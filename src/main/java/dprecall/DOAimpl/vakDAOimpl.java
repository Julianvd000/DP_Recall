package dprecall.DOAimpl;

import dprecall.OracleBaseDao;
import dprecall.DAO.vakDAO;
import dprecall.entitys.vak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vakDAOimpl extends OracleBaseDao implements vakDAO {
    private Connection conn;

    public boolean save(vak vak) throws SQLException {
        String sql = "INSERT INTO VAK (`CODE`,`NAAM`,`ECTS`) VALUES (?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, vak.getCode());
        statement.setString(2, vak.getNaam());
        statement.setInt(3, vak.getECTS());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("vak toegevoegd");
            return true;
        }
        conn.close();
        return false;
    }
}
