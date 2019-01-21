package com.accolite.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accolite.Services.Conn;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String name = new String();
		name = (String) session.getAttribute("name");
		if (name == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendRedirect("login");
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection con = Conn.connect(
				getServletContext().getInitParameter("driver"),
				getServletContext().getInitParameter("url"),
				getServletContext().getInitParameter("user"),
				getServletContext().getInitParameter("password")
				);
		if (con == null) {
			response.setContentType("text/html");
		    out.println("Sorry for the inconvience.Please try to fill the details again");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		else {
			try {
				con.setAutoCommit(false);
				Statement stmt = con.createStatement();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String nickname = request.getParameter("nickname");
				String city = request.getParameter("city");
				int result = stmt.executeUpdate("update users set username='"+username+"',password ='"+password+"',nickname ='"+nickname+"',city='"+city+"' where username = '"+request.getSession().getAttribute("name")+"'");
				con.commit();
				stmt.close();
				con.close();
				HttpSession session = request.getSession();
				session.setAttribute("name", username);
				session.setAttribute("nickname", nickname);
				session.setAttribute("city", city);
				session.setAttribute("password", password);
				session.setAttribute("success", "true");
				response.sendRedirect("Home");
			} catch (SQLException e) {
				System.out.println(e);
				response.setContentType("text/html");
			    out.println("Sorry for the inconvience.Please try to fill the details again");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		out.close();
	}
}
