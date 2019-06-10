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
 * Servlet implementation class ItemRegistrationServlet
 */
@WebServlet("/ItemRegistrationServlet")
public class ItemRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/ItemRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String photo = request.getParameter("photo");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String item_state = request.getParameter("itemState");
		String delivery = request.getParameter("delivery");
		String item_detail = request.getParameter("itemDetail");
		String user_id = request.getParameter("user_id");
		String item_num = request.getParameter("quantity");



		try {

			if (user_id.equals("")) {
				request.setAttribute("errMsg", "ログインしてください。");
				request.getRequestDispatcher("/WEB-INF/jsp/ItemRegistration.jsp").forward(request, response);
			}

			else if (photo.equals("") || name.equals("") || price.equals("") || item_state.equals("")
					|| delivery.equals("") || item_detail.equals("")) {
				request.setAttribute("errMsg", "全て入力してください。");
				request.getRequestDispatcher("/WEB-INF/jsp/ItemRegistration.jsp").forward(request, response);
			} else {
				ItemDataBeans idb = new ItemDataBeans();

				idb.setPhoto(photo);
				idb.setName(name);
				idb.setPrice(Integer.parseInt(price));
				idb.setItem_state(Integer.parseInt(item_state));
				idb.setDelivery(Integer.parseInt(delivery));
				idb.setDetail(item_detail);
				idb.setUser_id(Integer.parseInt(user_id));
				idb.setItem_num(Integer.parseInt(item_num));


				ItemDao.iteminsert(idb);
				response.sendRedirect("UserpageServlet?id=${userinfo.id}");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
