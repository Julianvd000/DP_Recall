package dprecall.DOAimpl;

import dprecall.OracleBaseDao;
import dprecall.DAO.vakDAO;
import dprecall.entitys.student;
import dprecall.entitys.vak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public vak update(vak vak) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE VAK set NAAM = ?, CODE = ?, ECTS = ? WHERE ID = ? ";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,vak.getNaam());
        statement.setString(2, vak.getCode());
        statement.setInt(3, vak.getECTS());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("vak aangepast");
        }
        conn.close();
        return vak;
    }

    public boolean delete(vak vak) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM VAK WHERE CODE = ? ";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, vak.getCode());


        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("vak verwijderd");
            return true;
        }
        conn.close();
        return false;
    }
    public List<vak> findAll() throws SQLException{
        List<vak> vakken = new ArrayList<vak>();
        conn = this.getConnection();

        String sql = "SELECT * FROM VAK";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            vak vak = new vak();
            vak.setECTS(result.getInt("ECTS"));
            vakken.add(vak);
        }
        return vakken;
    }
}
