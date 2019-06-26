package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Item_commentBeans;

public class item_commentDao {

	public static void insert(Item_commentBeans icb) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO item_comment(item_id,user_id,detail,create_date)VALUES(?,?,?,now())";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, icb.getItem_id());
			ps.setInt(2, icb.getUser_id());
			ps.setString(3, icb.getDetail());

			ps.executeUpdate();
			System.out.println("commentinsertOK!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}

	public static List<Item_commentBeans> getcomment(int item_id) throws SQLException {
		Connection con = null;
		List<Item_commentBeans> icblist = new ArrayList<Item_commentBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM item_comment"
					+ " INNER JOIN user ON item_comment.user_id = user.id "
					+ "WHERE item_id = ? "
					+ "ORDER BY item_comment.create_date DESC";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, item_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Item_commentBeans icb = new Item_commentBeans();
				icb.setItem_id(rs.getInt("item_id"));
				icb.setUser_id(rs.getInt("user_id"));
				icb.setDetail(rs.getString("detail"));
				icb.setCreate_date(rs.getTimestamp("create_date"));
				icb.setUserName(rs.getString("user.name"));

				icblist.add(icb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
		return icblist;
	}
}
