package dprecall.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class VolgtHibernateDaoImpl extends HibernateBaseDao{
	public List<Volgt> findAll() throws SQLException {
		Session session = getSession();
		List<Volgt> volgten = session.createQuery("FROM Volgt").list();
		session.close();
		return volgten;
	}
	
	public List<Volgt> findVakkenByStudent(int id) throws SQLException {
		Session session = getSession();
		List<Volgt> volgten = session.createQuery("FROM Volgt WHERE student_id = " + id).list();
		session.close();
		return volgten;
	}

	public Volgt save(Volgt volgt) throws SQLException {
		Session session = getSession();
		session.save(volgt);
		session.close();
		return volgt;
	}

	public boolean delete(Volgt volgt) throws SQLException {
		try {
			Session session = getSession();
			session.delete(volgt);
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
