package com.digit.hibernateServlet.Model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.AadharDetails;

public class HibernateManager {
	public static Session session;

	public HibernateManager() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();

		System.out.println("Connected to pf..........");

	}

	public boolean register(AadharDetails a1) {

		Transaction tran = session.beginTransaction();

		Serializable save = session.save(a1);

		tran.commit();

		System.out.println("object saved");
		if (save == null) {
			return false;
		}

		return true;

	}

	public List showAll() {
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("From AadharDetails");
		List li = q.list();
		tran.commit();
		return li;
	}

	public void deleteData(int aadharId) {
		Transaction tran = session.beginTransaction();
		AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharId); // value is based on Primary key

		session.delete(s);

		System.out.println("Delete Success");
		tran.commit();

	}

	public void updateData(int aadharId, int choice, String newValue) {
		Transaction tran = session.beginTransaction();
		AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharId); // value is based on Primary key

		switch (choice) {
		case 1:
			s.setPhone(newValue);
			break;
		case 2:
			s.setEmail(newValue);
			break;
		
		}

		session.update(s);

		System.out.println("Update Success");
		tran.commit();

	}

	public AadharDetails getSpecificUser(int aadharId) {
		session.beginTransaction();
		AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharId);
		System.out.println(s.getName());

		return s;

	}

}
