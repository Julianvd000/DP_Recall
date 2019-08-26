package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

public class KlasHibernateDaoImpl extends HibernateBaseDao{

	public List<Klas> findAll() throws SQLException {
		Session session = getSession();
		List<Klas> klassen = session.createQuery("FROM Klas").list();
		session.close();
		return klassen;
	}
	
	public Object findByKlasCode(String code) throws SQLException {
		Session session = getSession();
		Object k = session.get(Klas.class, code);
		session.close();
		return k;
	}

	public Klas save(Klas klas) throws SQLException {
		Session session = getSession();
		session.save(klas);
		session.close();
		return klas;
	}

	public Klas update(Klas klas) throws SQLException {
		Session session = getSession();
		session.update(klas);
		session.close();
		return klas;
	}

	public boolean delete(Klas klas) throws SQLException {
		try {
			Session session = getSession();
			session.delete(klas);
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
