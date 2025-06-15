package practice1.practice2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.StaticFilterAliasGenerator;

import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

public class App {
	public static void main(String[] args) {
		create();
		read();
//		update();
//		delete();
	}

	public static void create() {
		Configuration cfg = new Configuration().configure("hib.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();

		Session sess = fact.openSession();
		Transaction tx = sess.beginTransaction();

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Roll No: ");
		int roll = sc.nextInt();
		sc.nextLine(); // consume newline

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter CGPA: ");
		float cgpa = sc.nextFloat();
		sc.nextLine(); // consume newline

		System.out.print("Enter Branch: ");
		String branch = sc.nextLine();

		Students st = new Students(roll, name, cgpa, branch);

		sess.persist(st);

		tx.commit();
	}


	public static void read() {
		Configuration cfg = new Configuration().configure("hib.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();

		Session sess = fact.openSession();

		Students st = sess.find(Students.class, 3);
		System.out.println(st);
	}

	public static void update() {
		Configuration cfg = new Configuration().configure("hib.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();

		Session sess = fact.openSession();
		Transaction tx = sess.beginTransaction();

		Students st = sess.find(Students.class, 3);
		st.setName("Deepika");

		sess.merge(st);

		tx.commit();
	}

	public static void delete() {
		Configuration cfg = new Configuration().configure("hib.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();

		Session sess = fact.openSession();
		Transaction tx = sess.beginTransaction();

		Students st = sess.find(Students.class, 3);
		st.setName("Deepika");

		sess.remove(st);

		tx.commit();

	}
}