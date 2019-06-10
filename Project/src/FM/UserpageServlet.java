package FM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class UserpageServlet
 */
@WebServlet("/UserpageServlet")
public class UserpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserpageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		try {
			UserDataBeans udb = UserDao.getuser(Integer.parseInt(id));
			request.setAttribute("user", udb);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		try {
			ArrayList<ItemDataBeans> idb = ItemDao.itemcontents(Integer.parseInt(id));
			request.setAttribute("itemlist",idb);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/jsp/Userpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
