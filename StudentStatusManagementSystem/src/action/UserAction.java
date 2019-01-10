package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.Alisa.Entity.User;
import com.opensymphony.xwork2.ModelDriven;

import db.Database;

public class UserAction extends SuperAction{

	private static final long serialVersionUID = 1L;
//	private User user=new User();
	private User user;
	
	public String register(){
		System.out.println("ModelDriven:user:"+user.getCla());
		System.out.println("ModelDriven:user:"+user.getUserName());
		Database database=new Database();
		if (database.register(user)) {
			
			return "register_success";
		}else {
			return "register_fail";
		}
	}
	
	public String update(){
		System.out.println("ModelDriven:user:"+user.getAccount());
		Database database=new Database();
		if (database.update(user)) {
			
			return "update_success";
		}else {
			return "update_fail";
		}
	}
	@SkipValidation
	public String delete(){
		System.out.println("ModelDriven:user:"+user.getAccount());
		Database database=new Database();
		if (database.delete(user)) {
			
			return "delete_success";
		}else {
			return "delete_fail";
		}
	}
	
	
	
//	@Override
//	public void validate() {
//		// TODO Auto-generated method stub
////		super.validate();
//		String acc=user.getAccount()+"";
//		if(acc.length()!=4||user.getAccount()<0||user.getAccount()>9999){
//			addFieldError("account","长度必须为4且必须为数字");
//		}
//		if(user.getPassword().length()<4){
//			addFieldError("password","长度必须大于4位");
//		}
//		if (user.getType()!="s"||user.getType()!="S"||user.getType()!="t"||user.getType()!="T"||user.getType()!="admin") {
//			addFieldError("type","输入类型错误");
//		}
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	@Override
//	public User getModel() {
//		// TODO Auto-generated method stub
//		return user;
//	}

}
