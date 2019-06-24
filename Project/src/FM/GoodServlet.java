package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodDataBeans;
import dao.GoodDao;

/**
 * Servlet implementation class GoodServlet
 */
@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodServlet() {
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
		String item_id = request.getParameter("item_id");
		String user_id = request.getParameter("user_id");

		GoodDataBeans gdb = new GoodDataBeans();
		gdb.setItem_id(Integer.parseInt(item_id));
		gdb.setUser_id(Integer.parseInt(user_id));

		try {
			if (GoodDao.goodcheck(Integer.parseInt(item_id), Integer.parseInt(user_id)) == null) {
				GoodDao.goodinsert(gdb);
			} else {
				GoodDao.gooddelete(gdb);
			}

			response.sendRedirect("ItemServlet" + "?id=" + item_id);

		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
