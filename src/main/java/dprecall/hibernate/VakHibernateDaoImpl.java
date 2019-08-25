package dprecall.hibernate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class VakHibernateDaoImpl extends HibernateBaseDao{
	
	public List<Vak> findAll() throws SQLException {
		Session session = getSession();
		List<Vak> vakken = session.createQuery("FROM vak").list();
		closeSession();
		return vakken;
	}
	
	public Vak findByVakCode(String code) throws SQLException {
		Session session = getSession();
		Vak v = session.get(Vak.class, code);
		closeSession();
		return v;
	}

	public Vak save(Vak vak) throws SQLException {
		Session session = getSession();
		session.save(vak);
		closeSession();
		return vak;
	}


	public Vak update(Vak vak) throws SQLException {
		Session session = getSession();
		session.update(vak);
		closeSession();
		return vak;
	}

	public boolean delete(Vak vak) throws SQLException {
		try {
			Session session = getSession();
			session.delete(vak);
			closeSession();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}