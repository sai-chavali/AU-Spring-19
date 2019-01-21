import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Xmlservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("Server Initialised");
	}

	public void destroy() {
		System.out.println("Service method deleted");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter wrt = response.getWriter();
		wrt.print("<table border=1px>");
		Enumeration<String> header = request.getHeaderNames();
		while (header.hasMoreElements()) {
			String key = (String) header.nextElement();
			wrt.print("<tr><td><b>" + key + "</b></td>");
			String value = request.getHeader(key);
			wrt.println("<td>" + value + "</td></tr>");
		}
		wrt.print("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
