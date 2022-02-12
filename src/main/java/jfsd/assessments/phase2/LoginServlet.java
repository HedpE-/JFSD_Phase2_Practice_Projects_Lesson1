package jfsd.assessments.phase2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jfsd.assessments.phase2.database.UsersDB;
import jfsd.assessments.phase2.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameOrEmail = request.getParameter("username").toString();
		PrintWriter out = response.getWriter();
		
		String uname = UsersDB.validateUserExists(usernameOrEmail);
		if(uname != null) {
			User user = UsersDB.getUser(uname);
			String password = request.getParameter("password").toString();
			
			if(user.validatePassword(password)) {
//				RequestDispatcher rd = request.getRequestDispatcher("Dashboard?uname="+user.getUname());
				response.sendRedirect("Dashboard?uname="+user.getUname());
				return;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request,  response);
		out.println("<center> <span style='color:red'>Invalid Credentials</span></center>");
	}

}
