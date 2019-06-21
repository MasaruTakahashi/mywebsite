package FM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import beans.Item_commentBeans;
import dao.ItemDao;
import dao.item_commentDao;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id =request.getParameter("id");
		try {

			ItemDataBeans idb = ItemDao.getitem(Integer.parseInt(Id));
			request.setAttribute("item", idb);

			List<Item_commentBeans> icb = item_commentDao.getcomment(Integer.parseInt(Id));
			if(icb.isEmpty()) {
				request.setAttribute("isEmpty", "コメントはまだありません。");
			}else {
			request.setAttribute("commentlist", icb);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Item.jsp");
			dispatcher.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
