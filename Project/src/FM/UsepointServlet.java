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
 * Servlet implementation class UsepointServlet
 */
@WebServlet("/UsepointServlet")
public class UsepointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsepointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String item_id = request.getParameter("item_id");
		String usepoint = request.getParameter("usepoint");

		try {
			UserDataBeans udb = UserDao.getuser(Integer.parseInt(user_id));
			ItemDataBeans idb = ItemDao.getitem(Integer.parseInt(item_id));

			if(usepoint.equals("")) {
			udb.setUsepoint(0);
			}else if(udb.getPoint() < Integer.parseInt(usepoint)) {
				udb.setUsepoint(0);
				request.setAttribute("errMsg", "保有ポイントを超えています");
			}else {
				udb.setUsepoint(Integer.parseInt(usepoint));
			}
			int usepoint1 = udb.getUsepoint();
			int price = idb.getPrice();

			udb.setTotalprice(price - usepoint1);

			request.setAttribute("user", udb);
			request.setAttribute("item", idb);

			request.getRequestDispatcher("/WEB-INF/jsp/Buy.jsp").forward(request, response);

		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}

