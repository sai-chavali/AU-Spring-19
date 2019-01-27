package com.accolite.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.Services.Authentication;
import com.accolite.Services.Conn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("username");
		Connection con = Conn.connect(
				getServletContext().getInitParameter("driver"),
				getServletContext().getInitParameter("url"),
				getServletContext().getInitParameter("user"),
				getServletContext().getInitParameter("password")
				);
		if (Authentication.validate(con, name, request.getParameter("password"))) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users where username='" + name + "'");
				while(rs.next()) {
					session.setAttribute("name", rs.getString("username"));
					session.setAttribute("password", rs.getString("password"));
					session.setAttribute("nickname", rs.getString("nickname"));
					session.setAttribute("city", rs.getString("city"));
				}
				con.close();
			} catch (SQLException e) {
				System.out.println("Sql Exception:" + e);
				response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("Sorry for the inconvience.Please try to fill the details again");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				out.close();
			}
			response.sendRedirect("Home");
		} else {
			request.setAttribute("logmsg", "Invalid credentials.Please try to relogin");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
