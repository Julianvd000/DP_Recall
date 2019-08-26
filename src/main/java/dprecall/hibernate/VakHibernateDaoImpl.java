package dprecall.hibernate;

import java.sql.*;
import java.util.List;

import org.hibernate.Session;

public class VakHibernateDaoImpl extends HibernateBaseDao{
	
	public List<Vak> findAll() throws SQLException {
		Session session = getSession();
		List<Vak> vakken = session.createQuery("FROM Vak").list();
		session.close();
		return vakken;
	}
	
	public Object findByVakCode(String code) throws SQLException {
		Session session = getSession();
		Object v = session.get(Vak.class, code);
		session.close();
		return v;
	}

	public Vak save(Vak vak) throws SQLException {
		Session session = getSession();
		session.save(vak);
		session.close();
		return vak;
	}


	public Vak update(Vak vak) throws SQLException {
		Session session = getSession();
		session.update(vak);
		session.close();
		return vak;
	}

	public boolean delete(Vak vak) throws SQLException {
		try {
			Session session = getSession();
			session.delete(vak);
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}