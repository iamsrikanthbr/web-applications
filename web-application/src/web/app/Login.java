package web.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 8947951407202974286L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if ("srikanth@email.com".equals(email) && "password".equals(password)) {
			response.sendRedirect(request.getContextPath() + "/welcome.html");
		} else {
			response.sendRedirect(request.getContextPath() + "/login-error.html");
		}
	}
}
