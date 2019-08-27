package dprecall.hibernate;

import java.sql.*;
import java.util.List;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VakHibernateDaoImpl extends HibernateBaseDao{
	
	public List<Vak> findAll() throws SQLException {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Vak> q = cb.createQuery(Vak.class);
		Root<Vak> c = q.from(Vak.class);

		q.select(c);

		TypedQuery<Vak> query = session.createQuery(q);

		List<Vak> results = query.getResultList();

		return results;
	}
	
	public Object findByVakCode(String code) throws SQLException {
		Session session = getSession();
		Object v = session.get(Vak.class, code);
		session.getTransaction().commit();
		return v;
	}

	public Vak save(Vak vak) throws SQLException {
		Session session = getSession();
		session.save(vak);
		session.getTransaction().commit();
		return vak;
	}


	public Vak update(Vak vak) throws SQLException {
		Session session = getSession();
		session.update(vak);
		session.getTransaction().commit();
		return vak;
	}

	public boolean delete(Vak vak) throws SQLException {
		try {
			Session session = getSession();
			session.delete(vak);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}