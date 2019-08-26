package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;


public class StudentHibernateDaoImpl extends HibernateBaseDao{
	public List<Student> findAll() throws SQLException {
		Session session = getSession();
		List studenten = session.createQuery("From Student").list();
		session.close();
		return studenten;
	}
	
	public Object findByID(int id) throws SQLException {
		Session session = getSession();
		Object s = session.get(Student.class, id);
		session.close();
		return s;
	}
    
	public List<Student> findByKlas(String code) throws SQLException {
		Session session = getSession();
		List<Student> studenten = session.createQuery("FROM student WHERE klas_code = " + code).list();
		session.close();
		return studenten;
	}

	public Student save(Student student) throws SQLException {
		Session session = getSession();
		session.save(student);
		session.close();
		return student;
	}

	public Student update(Student student) throws SQLException {
		Session session = getSession();
		session.update(student);
		session.close();
		return student;
	}

	public boolean delete(Student student) throws SQLException {
		try {
			Session session = getSession();
			session.delete(student);
			session.close();;
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}


