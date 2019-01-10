package db;


import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Alisa.Entity.Grade;
import com.Alisa.Entity.User;


public class GradeDatabase{
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	public boolean add(Grade grade){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		String sql="select u.account from User u where account="+grade.getAccount();
		Query queryTemp=session.createQuery(sql);
		if (queryTemp.list().size()==1) {
			session.save(grade);
			SimpleDateFormat f=new SimpleDateFormat("yyyy_MM_dd");
			java.util.Date utilDate=new java.util.Date();
			String formatDate=f.format(utilDate.getTime());
			System.out.println("yyyy_MM_dd"+formatDate);
			String month=formatDate.substring(5,7);
			String year;
			if(Integer.valueOf(month)>=1&&Integer.valueOf(month)<=6){
				
				year=formatDate.substring(0, 4)+"privious";
			}else {
				year=formatDate.substring(0, 4)+"next";
			}
			
			String hql="update Grade set date='"+year+"' where account="+grade.getAccount();
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.save(grade);
			transaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(Grade grade){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		String hql="update Grade set grade="+grade.getGrade()+"where account="
		+grade.getAccount()+"and subject='"+grade.getSubject()+"'";
		Query query=session.createQuery(hql);
		query.executeUpdate();
//		session.save(grade);
		transaction.commit();
		return true;
	}
	public boolean delete(Grade grade){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		
		transaction = session.beginTransaction();
		String hql="delete from Grade where account="+grade.getAccount();
		Query query=session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		return true;
	}
	
public boolean importG(Grade grade){
		
		return true;
	}
}
