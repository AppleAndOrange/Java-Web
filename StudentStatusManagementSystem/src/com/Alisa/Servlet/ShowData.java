package com.Alisa.Servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(request, response);
		String toJSP="";  
        request.setCharacterEncoding("gbk");  
        response.setContentType("text/html;charset=gbk");  
        String time=request.getParameter("time"); 
        String subject=request.getParameter("subject");  
        System.out.println("time"+time);
        String sql = null;
        if(time!=""&&subject==""){
        	System.out.println(request.getSession().getAttribute("account"));
        	sql="select * from grade where date='"+time+"' and account="+Long.valueOf(request.getSession().getAttribute("account")+"");
        }else if (subject!=""&&time=="") {
        	sql="select * from grade where subject='"+subject+"' and account="+Long.valueOf(request.getSession().getAttribute("account")+"");
		}else if (subject!=""&&time!="") {
			sql="select * from grade where subject='"+subject+"' and  date='"+time+"' and account="+Long.valueOf(request.getSession().getAttribute("account")+"");
		}
        JdbcBean jdbc=new JdbcBean();  
        try{  
            ResultSet rs=jdbc.query(sql);  
            if(rs.next()){
            	HttpSession session=request.getSession();
            	session.setAttribute("result", rs);
                toJSP="Student/result.jsp"; 
            }  
//            rs.close();  
        }  
        catch(Exception e){  
            System.out.println("occur exception");  
        }  
        RequestDispatcher rd=request.getRequestDispatcher(toJSP);  
        rd.forward(request, response);  
        return;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		return;
	}
}
