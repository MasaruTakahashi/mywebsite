package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemDataBeans;

public class ItemDao {

	public static ArrayList<ItemDataBeans> itemcontents(int user_id) throws SQLException {

		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM item WHERE user_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user_id);

			ResultSet rs = ps.executeQuery();
			ArrayList<ItemDataBeans> idbList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPhoto(rs.getString("photo"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));

				idbList.add(idb);

			}
			return idbList;

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

	}

	public static void iteminsert(ItemDataBeans idb) throws SQLException {
		Connection con = null;

		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO item(photo,name,price,item_state,delivery,detail,user_id,item_num,create_date)"
					+ "VALUES(?,?,?,?,?,?,?,?,now())";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "img\\" + idb.getPhoto());
			ps.setString(2, idb.getName());
			ps.setInt(3, idb.getPrice());
			ps.setInt(4, idb.getItem_state());
			ps.setInt(5, idb.getDelivery());
			ps.setString(6, idb.getDetail());
			ps.setInt(7, idb.getUser_id());
			ps.setInt(8, idb.getItem_num());

			ps.executeUpdate();
			System.out.println("iteminsertOK!");
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

	public static ItemDataBeans getitem(int id) throws SQLException {
		Connection con = null;
		ItemDataBeans idb = null;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM item"
					+ " INNER JOIN item_state ON item.item_state = item_state.id"
					+ " INNER JOIN delivery ON item.delivery = delivery.id"
					+ " WHERE item.id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				String photo = rs.getString("photo");
				String name = rs.getString("name");
				String isd = rs.getString("item_state")
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
