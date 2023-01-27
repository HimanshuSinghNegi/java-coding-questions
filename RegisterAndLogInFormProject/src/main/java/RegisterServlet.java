import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseinfo.ConnectionProvider;
import model.Model;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// now first take out all the data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String pNo = request.getParameter("p_no");
		String address = request.getParameter("address");
		String remMe = request.getParameter("rememberMe");

		if (remMe == null) {
			remMe = "off";
		}
//		
//		System.out.println(Arrays.asList(remMe));
		// here fit everything inside a Model object
//		Model model = new Model(email,name,pass,pNo,address,remMe);

		// now make connection to the database
		try {
			con = ConnectionProvider.getConnection();

			// initialize the PreparedStatement
			PreparedStatement ps = con.prepareStatement("insert into register_form values(?,?,?,?,?,?)");

			// now here setting values to the preparedSatement

			ps.setString(1, email);

			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setString(4, pNo);
			ps.setString(5, address);
			ps.setString(6, remMe);
			// now executeQuery
			int i = ps.executeUpdate();
			if (i > 0) {
				PrintWriter pw = response.getWriter();
				pw.println("your data successfully stored into database");
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("something wrong");
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
