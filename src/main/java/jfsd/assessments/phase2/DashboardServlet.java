package jfsd.assessments.phase2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jfsd.assessments.phase2.database.UsersDB;
import jfsd.assessments.phase2.entities.User;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        System.out.println("Dashboard Servlet");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String uname = request.getParameter("uname");
		User user = UsersDB.getUser(uname);
		response.setContentType("text/html");
		writer.println("<html><head><style>h1 {color:green}</style></head><body>");
		writer.println("<h1>Welcome "+user.getFname()+"</h1>");
		writer.println("<div><h3>Your details</h3>");
		writer.println("<h4>User Name: "+user.getUname() +"</h4>");
		writer.println("<h4>Name: "+user.getFname() +"</h4>");
		writer.println("<h4>E-mail: "+user.getEmail() +"</h4>");
		writer.println("</div><br/><a href='Logout'>Logout</a></body></html>");
	}
}
