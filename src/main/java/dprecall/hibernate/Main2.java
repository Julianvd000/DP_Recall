package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;


//Ik gebruik de annotations manier voor P5. Deze main wordt voor P5 gebruikt.
public class Main2 {
	private static HibernateBaseDao dao = new HibernateBaseDao();
	private static StudentHibernateDaoImpl studentdao = new StudentHibernateDaoImpl();
	private static VakHibernateDaoImpl vakdao = new VakHibernateDaoImpl();
	private static KlasHibernateDaoImpl klasdao = new KlasHibernateDaoImpl();
	private static VolgtHibernateDaoImpl volgtdao = new VolgtHibernateDaoImpl();

	
	public static void main(String[] args) throws SQLException {
		dao.getFactory();
		
		Klas klas1 = new Klas("V1A", "Meneer Janssen", 2019);
		Student student1 = new Student(00001, "Dennis de Braan", null, "V1A");
		Vak vak1 = new Vak("PROG", "Programmeren", 5);
		Volgt volgt1 = new Volgt(00001, "PROG");
		
		Klas klas2 = new Klas("V1A", "Wilma Petersen", 2020);
		Student student2 = new Student(00001, "Jelle de Snelle", null, "V1A");
		Vak vak2 = new Vak("WAC", "Web Application Construction", 5);
		
		//save
		studentdao.save(student1);
		klasdao.save(klas1);
		vakdao.save(vak1);
		volgtdao.save(volgt1);
		
		System.out.println("ALLE STUDENTEN NA SAVE:");
		printStudenten(studentdao.findAll());
		
		System.out.println("ALLE VAKKEN NA SAVE:");
		printVakken(vakdao.findAll());
		
		System.out.println("ALLE KLASSEN NA SAVE:");
		printKlassen(klasdao.findAll());
		
		System.out.println("ALLE VOLGTEN NA SAVE:");
		printVolgten(volgtdao.findAll());
		
		// update
		studentdao.update(student2);
		klasdao.update(klas2);
		vakdao.update(vak2);
		
		System.out.println("ALLE STUDENTEN NA UPDATE:");
		printStudenten(studentdao.findAll());
		
		System.out.println("ALLE VAKKEN NA UPDATE:");
		printVakken(vakdao.findAll());
		
		System.out.println("ALLE KLASSEN NA UPDATE:");
		printKlassen(klasdao.findAll());
		
		//delete
		studentdao.delete(student2);
		klasdao.delete(klas2);
		vakdao.delete(vak2);
		volgtdao.delete(volgt1);
		
		System.out.println("ALLE STUDENTEN NA DELETE:");
		printStudenten(studentdao.findAll());
		
		System.out.println("ALLE VAKKEN NA DELETE:");
		printVakken(vakdao.findAll());
		
		System.out.println("ALLE KLASSEN NA DELETE:");
		printKlassen(klasdao.findAll());
		
		System.out.println("ALLE VOLGTEN NA DELETE:");
		printVolgten(volgtdao.findAll());
		
		dao.closeFactory();
	}

	public static void printStudent(Student s) {
		try {
			System.out.println(String.format("Student: %s, %s %s, %s", s.getID(), s.getNaam(), s.getGBdatum(), s.getKlasCode()));			
		} catch (Exception e) {
			System.out.println("Geen studenten gevonden");
		}
	}
	
	public static void printStudenten(List<Student> studenten) {
		for(Student s : studenten) {
			printStudent(s);
		}
		System.out.println();
	}
	
	public static void printVak(Vak v) {
		try {
			System.out.println(String.format("Vak: %s, %s %s", v.getCode(), v.getECTS(), v.getNaam()));			
		} catch (Exception e) {
			System.out.println("Geen studenten gevonden");
		}
	}
	
	public static void printVakken(List<Vak> vakken) {
		for(Vak v : vakken) {
			printVak(v);
		}
		System.out.println();
	}
	
	public static void printKlas(Klas k) {
		try {
			System.out.println(String.format("Student: %s, %s %s", k.getKlasCode(), k.getMentor(), k.getStartjaar()));			
		} catch (Exception e) {
			System.out.println("Geen studenten gevonden");
		}
	}
	
	public static void printKlassen(List<Klas> klassen) {
		for(Klas k : klassen) {
			printKlas(k);
		}
		System.out.println();
	}
	
	public static void printVolgt(Volgt v) {
		try {
			System.out.println(String.format("Student: %s, %s", v.getStudentID(), v.getVakCode()));			
		} catch (Exception e) {
			System.out.println("Geen studenten gevonden");
		}
	}
	
	public static void printVolgten(List<Volgt> volgten) {
		for(Volgt v : volgten) {
			printVolgt(v);
		}
		System.out.println();
	}
}













