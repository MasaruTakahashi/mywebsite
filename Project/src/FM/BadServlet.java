package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class BadServlet
 */
@WebServlet("/BadServlet")
public class BadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");

		if (isLogin == null) {
			response.sendRedirect("LoginServlet");
		} else {
			String id = request.getParameter("id");
			String item_id = request.getParameter("item_id");

			UserDataBeans udb = new UserDataBeans();
			udb.setId(Integer.parseInt(id));
			try {
				UserDao.userbad(udb);
				response.sendRedirect("ItemServlet" + "?id=" + item_id);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
