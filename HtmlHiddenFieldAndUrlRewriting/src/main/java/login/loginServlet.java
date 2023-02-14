package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");
		response.getWriter().println(name);
		response.getWriter().println(pass);
		response.setContentType("text/html");
		//here is the method of "Html Hidden Field"
		// in this method we can only manage the client data not client state
		response.getWriter().print("<html><body>"
				+"<form action='nextServlet' method='post'>"
				+ "<input type='hidden' name='userName' value='"+name+"'>"+
				 "<input type='hidden' name='pass' value='"+pass+"'>"+
				  "<input type='submit'>"
				+ "</form>"
				+ "</body></html>");
	}

}
