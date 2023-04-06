package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class ServletForwarding
 */
public class ServletForwarding extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ServletForwarding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("uname");
		String s2=request.getParameter("pword");
		ServletContext sc=getServletContext();
		if((s1.equals("bhargav"))&&(s2.equals("bunny")))
		{
			RequestDispatcher rd=sc.getRequestDispatcher("/welcome");
			rd.forward(request, response);
		}
		else
		{
			PrintWriter pw=response.getWriter();
			pw.println("<font color=red>");
			pw.println("Invalid Username/Password</font>");
			RequestDispatcher rd=sc.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
	}

}
