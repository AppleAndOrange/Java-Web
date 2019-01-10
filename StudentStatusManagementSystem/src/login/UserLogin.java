package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Alisa.Entity.Login;

public class UserLogin{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private String hql;
	
	public String login(Login loginUser){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		hql="select type from User where account="+loginUser.getAccount();
		Query query=session.createQuery(hql);
		Query query2=session.createQuery("select password from User where account="+loginUser.getAccount());
		List<String> list=query.list();
		List<String> list2=query2.list();
		transaction.commit();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession httpSession=request.getSession();
		String code=String.valueOf(httpSession.getAttribute("code"));
		httpSession.setAttribute("account", loginUser.getAccount());
		System.out.println("code"+code);
		String randNumber="null"+loginUser.getRandNumber();
		System.out.println("loginUser.getRandNumber()"+loginUser.getRandNumber());
		System.out.println(list.size());
		if(list.size()>0){
			if(list.get(0).equals("admin")&&list2.get(0).equals(loginUser.getLoginPassword())&&randNumber.equals(code)){
				return "admin";
			}else if ((list.get(0).equals("T")||list.get(0).equals("t"))
					&&list2.get(0).equals(loginUser.getLoginPassword())&&randNumber.equals(code)) {
				return "teacher";
			}else if ((list.get(0).equals("S")||list.get(0).equals("s"))
					&&list2.get(0).equals(loginUser.getLoginPassword())&&randNumber.equals(code)) {
				System.out.println("student");
				return "student";
			}
		}
		return "error";
	}
	
}
