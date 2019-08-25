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
		List<Volgt> volgten = session.createQuery("FROM volgt").list();
		closeSession();
		return volgten;
	}
	
	public List<Volgt> findVakkenByStudent(int id) throws SQLException {
		Session session = getSession();
		List<Volgt> volgten = session.createQuery("FROM volgt WHERE student_id = " + id).list();
		closeSession();
		return volgten;
	}

	public Volgt save(Volgt volgt) throws SQLException {
		Session session = getSession();
		session.save(volgt);
		closeSession();
		return volgt;
	}

	public boolean delete(Volgt volgt) throws SQLException {
		try {
			Session session = getSession();
			session.delete(volgt);
			closeSession();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
