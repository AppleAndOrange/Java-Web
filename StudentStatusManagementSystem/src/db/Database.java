package db;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Alisa.Entity.User;

public class Database {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	public boolean register(User user) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
		System.out.println("successfully saved");
		return true;
	}
	public boolean update(User user) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		String hql="update User set password='"+user.getPassword()+"' where account="+user.getAccount();
		Query query=session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		System.out.println("successfully update");
		return true;
	}
	public boolean delete(User user) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		String hql="delete from User where account="+user.getAccount();
		Query query=session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		System.out.println("successfully delete");
		return true;
	}
	
}
