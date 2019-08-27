package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class KlasHibernateDaoImpl extends HibernateBaseDao implements KlasDAO{

	public List<Klas> findAll() throws SQLException {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Klas> q = cb.createQuery(Klas.class);
		Root<Klas> c = q.from(Klas.class);

		q.select(c);

		TypedQuery<Klas> query = session.createQuery(q);

		List<Klas> results = query.getResultList();

		return results;
	}
	
	public Object findByKlasCode(String code) throws SQLException {
		Session session = getSession();
		Object k = session.get(Klas.class, code);
		session.getTransaction().commit();
		return k;
	}

	public Klas save(Klas klas) throws SQLException {
		Session session = getSession();
		session.save(klas);
		session.getTransaction().commit();
		return klas;
	}

	public Klas update(Klas klas) throws SQLException {
		Session session = getSession();
		session.update(klas);
		session.getTransaction().commit();
		return klas;
	}

	public boolean delete(Klas klas) throws SQLException {
		try {
			Session session = getSession();
			session.delete(klas);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
