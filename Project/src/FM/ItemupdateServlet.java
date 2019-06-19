package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class ItemupdateServlet
 */
@WebServlet("/ItemupdateServlet")
public class ItemupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemupdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			ItemDataBeans idb = ItemDao.getitem(Integer.parseInt(id));
			request.setAttribute("item", idb);
			request.getRequestDispatcher("/WEB-INF/jsp/Itemupdate.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String photo = request.getParameter("photo");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String item_state = request.getParameter("itemState");
		String delivery = request.getParameter("delivery");
		String detail = request.getParameter("detail");

		if(item_state == null) {
			item_state = "0";
		}

		if(delivery == null) {
			delivery = "0";
		}
		if(price.equals("")) {
			price = "0";
		}

		if (photo.equals("") && name.equals("") && price.equals("") && item_state.equals("0") && delivery.equals("0")
				&& detail.equals("")) {
			request.setAttribute("errMsg", "変更する物がありません。");
			request.getRequestDispatcher("/WEB-INF/jsp/Itemupdate.jsp").forward(request, response);
		} else {
			try {
				ItemDao.update(Integer.parseInt(id), photo, name, Integer.parseInt(price), Integer.parseInt(item_state),
						Integer.parseInt(delivery), detail);
				response.sendRedirect("ItemServlet" + "?id=" + id);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
