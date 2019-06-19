package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserupdateServlet
 */
@WebServlet("/UserupdateServlet")
public class UserupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserupdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Userupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String detail = request.getParameter("detail");

		if (!password.equals(passwordCon)) {
			request.setAttribute("errMsg", "パスワードと確認が一致していません。");
			request.getRequestDispatcher("/WEB-INF/jsp/Userupdate.jsp").forward(request, response);
		}
		else if (password.equals("") && name.equals("") && address.equals("") && detail.equals("")) {
			request.setAttribute("errMsg", "変更する物がありません。");
			request.getRequestDispatcher("/WEB-INF/jsp/Userupdate.jsp").forward(request, response);
		} else {
			try {
				UserDao.update(password, name, address, detail, Integer.parseInt(id));
				response.sendRedirect("UserpageServlet" + "?id=" + id);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
