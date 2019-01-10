package com.Alisa.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import com.Alisa.Entity.Grade;

public class ImportData extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doPost(req, resp);
	req.setCharacterEncoding("utf-8");
	List <Grade> list;
	int id = 0;
	long account = 0;
	String date = null;
	String name = null;
	float grade=0;
	String cla=null;
	String subject=null;
	String toJSP=null;
	JdbcBean jdbcBean=new JdbcBean();
	list=getAllByExcel("G:/作业/软件工程/grade.xls");
	for(int i=0;i<list.size();i++){
		id=Integer.valueOf(list.get(i).getId());
		account=Long.valueOf(list.get(i).getAccount());
		date=list.get(i).getDate();
		name=list.get(i).getName();
		grade=Float.valueOf(list.get(i).getGrade());
		cla=list.get(i).getCla();
		subject=list.get(i).getSubject();
		String sql="insert into grade values("+id+","+account+",'"+cla+"',"+date+",'"+grade+"','"+name+"','"+subject+"')";
		boolean temp=jdbcBean.insert(sql);
		toJSP="Teacher/OperatorGrade.jsp"; 
		if(temp==false){
			System.out.println("fail");
		}else {
			System.out.println("success");
		}
	}
	RequestDispatcher rd=req.getRequestDispatcher(toJSP);  
    rd.forward(req, resp);  
    return;
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
public List<Grade> getAllByExcel(String file){
	List <Grade> list=new ArrayList<Grade>();
	try {
		Workbook rwb=Workbook.getWorkbook(new File(file));
		Sheet rs=rwb.getSheet("Sheet1");
		int clos=rs.getColumns();
		int rows=rs.getRows();
		System.out.println(clos+" rows:"+rows);
		for(int i=1;i<rows;i++){
			String id = null;
			String account = null;
			String date = null;
			String name = null;
			String grade=null;
			String cla=null;
			String subject=null;
			int j=0;
			id=rs.getCell(j,i).getContents();
			account=rs.getCell(++j,i).getContents();
			date=rs.getCell(++j,i).getContents();
			grade=rs.getCell(++j,i).getContents();
			name=rs.getCell(++j,i).getContents();
			cla=rs.getCell(++j,i).getContents();
			subject=rs.getCell(++j,i).getContents();
			System.out.println("id="+id+"account="+account+"date="+date+"name="+name);
			list.add(new Grade(Integer.valueOf(id),cla,Long.valueOf(account),name,subject,Float.valueOf(grade),date));
		}
		
	}  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
}
