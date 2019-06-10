package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		UserDataBeans udb = new UserDataBeans();
		udb.setLogin_id(login_id);
		udb.setPassword(password);
		udb.setName(name);
		udb.setAddress(address);

		try {

			if (UserDao.checkLogin_id(login_id) != null) {
				request.setAttribute("errMsg", "他のユーザーが使用しています。");

				request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp").forward(request, response);
			} else if (!password.equals(passwordCon)) {
				request.setAttribute("errMsg", "パスワードと確認が一致していません。");

				request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp").forward(request, response);
			} else if (login_id.equals("") || password.equals("") || name.equals("") || address.equals("")) {
				request.setAttribute("errMsg", "全て入力してください。");

				request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp").forward(request, response);
			} else {

				UserDao.userInsert(udb);
				response.sendRedirect("TopServlet");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
