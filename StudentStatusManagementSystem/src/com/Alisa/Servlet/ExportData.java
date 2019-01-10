package com.Alisa.Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String toJSP=null;
		try {
			JdbcBean jdbcBean=new JdbcBean();
			String cla=req.getParameter("class");
			String account=req.getParameter("account");
			
			String sql = null;
			if(cla==""&&account==""){
				
				sql="select * from grade";
			}else if(cla!=""&&account==""){
				sql="select * from grade where class='"+cla+"'";
			}else {
				sql="select * from grade where account="+Integer.valueOf(account);
			}
			System.out.println("jdbc");
			ResultSet resultSet=jdbcBean.query(sql);
			writeSheet(resultSet);
			toJSP="/Teacher/query.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void writeSheet(ResultSet resultSet){
            try {
            	WritableWorkbook workbook=null;
            	String fileName="G:/作业/软件工程/write.xls";
            	File file=new File(fileName);
            	if (!file.exists()) {
            		file.createNewFile();
            	}
            	System.out.println("Sheet1 successly");
            	workbook = Workbook.createWorkbook(file);
            	WritableSheet ws = workbook.createSheet("Sheet1", 0);
            	Label labelId=new Label(0,0,"id");
            	Label labelAccount=new Label(1,0,"Account");
            	Label labelDate=new Label(2,0,"Date");
            	Label labelGrade=new Label(3,0,"Grade");
            	Label labelName=new Label(4,0,"Name");
            	Label labelClass=new Label(5,0,"Class");
            	Label labelSubject=new Label(6,0,"Subject");
            	
            	ws.addCell(labelId);
            	ws.addCell(labelAccount);
            	ws.addCell(labelDate);
            	ws.addCell(labelGrade);
            	ws.addCell(labelName);
            	ws.addCell(labelClass);
            	ws.addCell(labelSubject);
            	int i=1;
            	while(resultSet.next()){
            		labelId=new Label(0,i,resultSet.getInt("id")+"");
            		labelAccount=new Label(1,i,resultSet.getLong("account")+"");
                	labelDate=new Label(2,i,resultSet.getString("date"));
                	labelGrade=new Label(3,i,resultSet.getFloat("grade")+"");
                	labelName=new Label(4,i,resultSet.getString("name"));
                	labelClass=new Label(5,i,resultSet.getString("class"));
                	labelSubject=new Label(6,i,resultSet.getString("subject"));
                	
                	ws.addCell(labelId);
                	ws.addCell(labelAccount);
                	ws.addCell(labelDate);
                	ws.addCell(labelGrade);
                	ws.addCell(labelName);
                	ws.addCell(labelClass);
                	ws.addCell(labelSubject);
            		i++;
            	}
            	workbook.write();
            	workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
        }
	}

