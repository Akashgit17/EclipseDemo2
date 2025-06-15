package hiber1.hiber1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
//    	oneTone();
		oneTmany();

	}

	public static void oneTone() {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tnx = session.beginTransaction();

		Person p = new Person();
		Aadhaar a = new Aadhaar(222, "Chetan", "Bangalore", "M", "17/11/2002", p);
		p.setId(2);
		p.setAadhaar(a);
		session.persist(p);
		session.persist(a);
		tnx.commit();
	}

	public static void oneTmany() {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tnx = session.beginTransaction();
		
		Company c = new Company();
		Employee e1 = new Employee(101, "Akash", "dev", 50000, c);
		Employee e2 = new Employee(202, "Chetan", "ops", 52000, c);

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		
		c.setcId(1);
		c.setEmpList(empList);
		
		session.persist(c);
		session.persist(e1);
		session.persist(e2);
		
		tnx.commit();
	}
}
