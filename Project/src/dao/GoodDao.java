package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.GoodDataBeans;

public class GoodDao {

	public static void goodinsert(GoodDataBeans gdb) throws SQLException {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO good(item_id,user_id)VALUES(?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gdb.getItem_id());
			ps.setInt(2, gdb.getUser_id());

			ps.executeUpdate();
			System.out.println("goodinsertOK!");

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

	public static void gooddelete(GoodDataBeans gdb)throws SQLException{
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "DELETE FROM good WHERE item_id = ? AND user_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gdb.getItem_id());
			ps.setInt(2, gdb.getUser_id());
			ps.executeUpdate();
			System.out.println("gooddeleteOK!");

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

	public static List<GoodDataBeans> gooditem(int user_id)throws SQLException{
		Connection con = null;
		List<GoodDataBeans> gdblist = new ArrayList<GoodDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM good INNER JOIN item ON good.item_id = item.id WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				GoodDataBeans gdb = new GoodDataBeans();
				gdb.setItem_id(rs.getInt("item_id"));
				gdb.setItemPhoto(rs.getString("item.photo"));
				gdb.setItemName(rs.getString("item.name"));
				gdb.setItemPrice(rs.getInt("item.price"));

				gdblist.add(gdb);
			}
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
		return gdblist;
	}
}
