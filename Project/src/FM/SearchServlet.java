package FM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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

		String searchword = request.getParameter("searchword");

		if (searchword.equals("")) {
			try {
				List<ItemDataBeans> idb = ItemDao.findall();
				request.setAttribute("itemlist", idb);
				request.getRequestDispatcher("/WEB-INF/jsp/Top.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			List<ItemDataBeans> idb = ItemDao.searchitem(searchword);

			if (idb.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/jsp/Nosearch.jsp").forward(request, response);
			}

			request.setAttribute("itemlist", idb);
			request.getRequestDispatcher("/WEB-INF/jsp/Top.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
