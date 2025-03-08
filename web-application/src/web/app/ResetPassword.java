package web.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (newPassword.equals(confirmPassword)) {
			resetUserPassword(email, newPassword);

			response.sendRedirect("login.html");
		} else {
			response.getWriter()
					.println("<html><body><h3>Passwords do not match. Please try again.</h3></body></html>");
		}
	}

	private void resetUserPassword(String email, String newPassword) {
		System.out.println("Password for " + email + " reset to: " + newPassword);
	}
}
