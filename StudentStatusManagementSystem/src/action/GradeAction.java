package action;

import com.Alisa.Entity.Grade;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import db.GradeDatabase;



public class GradeAction  extends ActionSupport implements ModelDriven<Grade>{
	private static final long serialVersionUID = 1L;
	private Grade grade=new Grade();
	
	
	public String addGrade(){
		GradeDatabase gradeDatabase=new GradeDatabase();
		if(gradeDatabase.add(grade)){
			return "add_success";
		}else {
			return "add_fail";
		}
	}
	
	public String deleteGrade(){
		System.out.println("grade.getGrade()+"+grade.getAccount());
		GradeDatabase gradeDatabase=new GradeDatabase();
		if (gradeDatabase.delete(grade)) {
			return "delete_success";
		}else {
			return "delete_fail";
		}
	}
	public String updateGrade(){
		GradeDatabase gradeDatabase=new GradeDatabase();
		if (gradeDatabase.update(grade)) {
			return "update_success";
		}else {
			return "update_fail";
		}
	}
	
	
	public String importGrade(){
		GradeDatabase gradeDatabase=new GradeDatabase();
		if(gradeDatabase.importG(grade)){
			
			return "import_success";
		}else {
			return "import_fail";
		}
	}
	
	@Override
	public Grade getModel() {
		// TODO Auto-generated method stub
		return grade;
	}
	
}
