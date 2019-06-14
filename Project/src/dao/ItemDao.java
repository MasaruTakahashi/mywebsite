package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ItemDataBeans;

public class ItemDao {

	public static List<ItemDataBeans> findall() throws SQLException {
		Connection con = null;
		List<ItemDataBeans> itemlist = new ArrayList<ItemDataBeans>();

		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM item";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPhoto(rs.getString("photo"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));

				itemlist.add(idb);
			}

			return itemlist;

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
					+ " INNER JOIN user ON item.user_id = user.id"
					+ " WHERE item.id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int Id = rs.getInt("id");
				String photo = rs.getString("photo");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String isd = rs.getString("item_state.detail");
				String dd = rs.getString("delivery.detail");
				String detail = rs.getString("detail");
				String username = rs.getString("user.name");
				String useraddress = rs.getString("user.address");
				int user_id = rs.getInt("user_id");

				idb = new ItemDataBeans(Id, photo, name, price, isd, dd, detail, username, useraddress, user_id);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idb;

	}

	public static void itemdelete(ItemDataBeans idb) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "DELETE FROM item WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, idb.getId());
			ps.executeUpdate();

			System.out.println("itemdeleteOK!");

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
}