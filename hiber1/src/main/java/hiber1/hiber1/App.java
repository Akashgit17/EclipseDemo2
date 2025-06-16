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
//		oneTmany();
		ManyToMany();

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

	public static void ManyToMany() {
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tnx = session.beginTransaction();

		Interview i1 = new Interview();
		Interview i2 = new Interview();
		Interview i3 = new Interview();
		Interview i4 = new Interview();

		// c1
		List<Interview> iList1 = new ArrayList<Interview>();
		iList1.add(i1);
		iList1.add(i2);
		// c2
		List<Interview> iList2 = new ArrayList<Interview>();
		iList2.add(i1);
		iList2.add(i3);
		// c3
		List<Interview> iList3 = new ArrayList<Interview>();
		iList3.add(i2);
		iList3.add(i3);
		iList3.add(i4);

		Candidate c1 = new Candidate(111, "Akash", iList1);
		Candidate c2 = new Candidate(222, "Chetan", iList2);
		Candidate c3 = new Candidate(333, "Akhil", iList3);

		// Interview
		List<Candidate> cList1 = new ArrayList<Candidate>();
		cList1.add(c1);
		cList1.add(c2);

		List<Candidate> cList2 = new ArrayList<Candidate>();
		cList2.add(c1);
		cList2.add(c3);

		List<Candidate> cList3 = new ArrayList<Candidate>();
		cList3.add(c2);
		cList3.add(c3);

		List<Candidate> cList4 = new ArrayList<Candidate>();
		cList4.add(c3);

		i1.setiId(1);
		i1.setiName("TCS");
		i1.setCandList(cList1);

		i2.setiId(2);
		i2.setiName("HCL");
		i2.setCandList(cList2);

		i3.setiId(3);
		i3.setiName("IBM");
		i3.setCandList(cList3);

		i4.setiId(4);
		i4.setiName("CGI");
		i4.setCandList(cList4);

		session.persist(c1);
		session.persist(c2);
		session.persist(c3);

		session.persist(i1);
		session.persist(i2);
		session.persist(i3);
		session.persist(i4);

		tnx.commit();

	}
}
