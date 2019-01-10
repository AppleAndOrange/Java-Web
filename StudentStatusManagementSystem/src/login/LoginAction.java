package login;

import com.Alisa.Entity.Login;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Login>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login login=new Login();
	
	
	public String login(){
		UserLogin userLogin=new UserLogin();
		if(userLogin.login(login).equals("admin")){
			System.out.println("admin_login_success");
			return "admin_login_success";
		}
		if(userLogin.login(login).equals("teacher")){
			System.out.println("teacher_login_success");
			return "teacher_login_success";
		}else if(userLogin.login(login).equals("student")){
			System.out.println("student_login_success");
			return "student_login_success";
		}else{
			System.out.println("user_login_failure");
			return "user_login_failure";
		}
		
	}
	@Override
	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

}
