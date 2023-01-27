

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseinfo.ConnectionProvider;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		// TODO Auto-generated method stub
		// now first take out all the data
				
				String email = request.getParameter("email");
				String pass = request.getParameter("password");
				response.setContentType("text/html");



				// now make connection to the database
				try {
					con = ConnectionProvider.getConnection();

					// initialize the PreparedStatement
					PreparedStatement ps = con.prepareStatement("select * from register_form where email=? and password=?");

					// now here setting values to the preparedSatement

					ps.setString(1, email);
					ps.setString(2, pass);
					// now executeQuery
					ResultSet rs = ps.executeQuery();
					 
					if(rs.next()) {
						RequestDispatcher dispatcher  = request.getRequestDispatcher("Welcome.html");
						dispatcher.forward(request, response);
					}
					else {
						PrintWriter pw = response.getWriter();
						pw.println("<h2 style='color: red; text-align:center;'>Please check your email and password again !!</h2>");
						RequestDispatcher dispatcher = request.getRequestDispatcher("LogInForm.html");
						dispatcher.include(request, response);
						
					}

				} catch (  SQLException e) {
					PrintWriter pw = response.getWriter();
					e.getClass();
					pw.println("make sure you filled correct data");
					e.printStackTrace();

				} finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

	}

}
