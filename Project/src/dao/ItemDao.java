package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ItemDataBeans;

public class ItemDao {

	public static ItemDataBeans itemcontents(int user_id) throws SQLException {

		Connection con = null;
		ItemDataBeans idb = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM item WHERE user_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String photo = rs.getString("photo");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				idb = new ItemDataBeans(id, photo, name, price);

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
		return idb;
	}
}
