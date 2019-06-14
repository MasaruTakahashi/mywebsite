package FM;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.ItemDao;

/**
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			ItemDataBeans idb = ItemDao.getitem(Integer.parseInt(id));
			request.setAttribute("item",idb);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/jsp/ItemDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		UserDataBeans user = (UserDataBeans) session.getAttribute("userinfo");

		String id =request.getParameter("id");

		ItemDataBeans idb = new ItemDataBeans();
		idb.setId(Integer.parseInt(id));

		try {
			ItemDao.itemdelete(idb);
			response.sendRedirect("UserpageServlet?id=" + user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
