package com.Alisa.Servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherQuery extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		req.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=gbk");
		String sClass = req.getParameter("class");
		System.out.println("sClass"+sClass);
		String toJSP = "";
		String sql="";
		String accString=req.getParameter("account");
		System.out.println("account="+accString);
		if(sClass!=""&&accString==""){
			sql = "select * from grade where class='" + sClass
					+ "'";
		}else if (accString!=""&&sClass=="") {
			int account = Integer.valueOf(req.getParameter("account"));
			sql = "select * from grade where account=" + account;
		}else {
			int account = Integer.valueOf(req.getParameter("account"));
			sql = "select * from grade where class='" + sClass
					+ "' and account=" + account;
		}
		JdbcBean jdbcBean = new JdbcBean();
		try {
			ResultSet rs = jdbcBean.query(sql);
			if (rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("result", rs);
				toJSP = "Teacher/result.jsp";
			}
			// rs.close();
		} catch (Exception e) {
			System.out.println("occur exception");
		}
		RequestDispatcher rd = req.getRequestDispatcher(toJSP);
		rd.forward(req, resp);
		return;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
