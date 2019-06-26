package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.ItemDao;
import dao.UserDao;

/**
 * Servlet implementation class BuyConfirmServlet
 */
@WebServlet("/BuyConfirmServlet")
public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyConfirmServlet() {
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

		String point = request.getParameter("point");
		String usepoint = request.getParameter("usepoint");
		String SellUser_id = request.getParameter("SellUser_id");
		String BuyUser_id = request.getParameter("BuyUser_id");
		String item_num = request.getParameter("item_num");
		String item_id = request.getParameter("item_id");
		String price = request.getParameter("price");

		UserDataBeans udb = new UserDataBeans();
		udb.setPoint(Integer.parseInt(point));
		udb.setUsepoint(Integer.parseInt(usepoint));
		udb.setId(Integer.parseInt(BuyUser_id));

		try {
			UserDao.pointuse(udb);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		ItemDataBeans idb = new ItemDataBeans();
		idb.setItem_num(Integer.parseInt(item_num));
		idb.setId(Integer.parseInt(item_id));

		try {
			ItemDao.itembuy(idb);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		udb.setId(Integer.parseInt(SellUser_id));

		try {
			UserDao.pointadd(udb, Integer.parseInt(price));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/jsp/BuyComplete.jsp").forward(request, response);
	}
}
