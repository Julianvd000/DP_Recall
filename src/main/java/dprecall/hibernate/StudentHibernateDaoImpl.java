package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class StudentHibernateDaoImpl extends HibernateBaseDao implements StudentDAO{
	public List<Student> findAll() throws SQLException {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> q = cb.createQuery(Student.class);
		Root<Student> c = q.from(Student.class);

		q.select(c);

		TypedQuery<Student> query = session.createQuery(q);

		List<Student> results = query.getResultList();
		return results;
	}
	
	public Object findByID(int id) throws SQLException {
		Session session = getSession();
		Object s = session.get(Student.class, id);
		return s;
	}
    
	public Student save(Student student) throws SQLException {
		Session s = getSession();
		s.beginTransaction();
		s.save(student);
		s.getTransaction().commit();
		s.close();
		return student;
	}

	public Student update(Student student) throws SQLException {
		Session s = getSession();
		s.beginTransaction();
		s.update(student);
		s.getTransaction().commit();
		s.close();
		return student;
	}

	public boolean delete(Student student) throws SQLException {
		try {
			Session s = getSession();
			s.beginTransaction();
			s.delete(student);
			s.getTransaction().commit();
			s.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}


