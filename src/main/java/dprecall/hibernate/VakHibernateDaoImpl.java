package dprecall.hibernate;

import java.sql.*;
import java.util.List;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VakHibernateDaoImpl extends HibernateBaseDao implements VakDAO{
	
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
		session.beginTransaction();
		Object v = session.get(Vak.class, code);
		session.getTransaction().commit();
		session.close();
		return v;
	}

	public Vak save(Vak vak) throws SQLException {
		Session session = getSession();
		session.beginTransaction();
		session.save(vak);
		session.getTransaction().commit();
		session.close();
		return vak;
	}


	public Vak update(Vak vak) throws SQLException {
		Session session = getSession();
		session.beginTransaction();
		session.update(vak);
		session.getTransaction().commit();
		session.close();
		return vak;
	}

	public boolean delete(Vak vak) throws SQLException {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.delete(vak);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}