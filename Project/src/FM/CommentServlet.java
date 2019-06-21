package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item_commentBeans;
import dao.item_commentDao;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Boolean logincheck = (Boolean) session.getAttribute("isLogin");
		if (logincheck == null) {
			response.sendRedirect("LoginServlet");
		} else {

			String item_id = request.getParameter("item_id");
			String user_id = request.getParameter("user_id");
			String detail = request.getParameter("detail");

			Item_commentBeans icb = new Item_commentBeans();
			icb.setItem_id(Integer.parseInt(item_id));
			icb.setUser_id(Integer.parseInt(user_id));
			icb.setDetail(detail);

			try {
				if (detail.equals("")) {
					response.sendRedirect("ItemServlet" + "?id=" + item_id);
				} else {
					item_commentDao.insert(icb);
					response.sendRedirect("ItemServlet" + "?id=" + item_id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
